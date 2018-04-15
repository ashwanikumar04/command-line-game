package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.CommandExecutor;
import in.ashwanik.clgame.commands.CommandParser;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.CommandMessage;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.Renderer;
import in.ashwanik.clgame.ui.screens.impl.WelcomeScreen;

import java.util.Objects;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
public class Game implements Subscriber {
    private static GameArena gameArena;
    private CommandParser commandParser;
    private boolean finished;
    private static boolean isDebug;
    private static boolean started;

    public Game(CommandParser commandParser) {
        EventBus.getInstance().subscribe(this, Topics.GAME_STATE);
        EventBus.getInstance().subscribe(this, Topics.COMMAND);
        this.commandParser = commandParser;
    }

    public static GameArena getGameArena() {
        return gameArena;
    }

    public static void setGameArena(GameArena ga) {
        EventBus.getInstance().subscribe(ga, Topics.GAME_STATE);
        gameArena = ga;
    }

    public static boolean isDebug() {
        return Game.isDebug;
    }

    public static boolean isStarted() {
        return Game.started;
    }

    public static void setDebug(boolean isDebug) {
        Game.isDebug = isDebug;
    }

    public void start(boolean processSingleCommand) {
        Renderer welcomeRenderer = new WelcomeScreen();
        welcomeRenderer.render();
        finished = false;
        while (!finished) {
            commandParser.publishIssuesCommand();
            finished = processSingleCommand;
        }
    }

    @Override
    public void receive(Message message) {
        switch (message.getMessageType()) {
            case COMMAND:
                CommandMessage commandMessage = (CommandMessage) message;
                CommandExecutor.execute(commandMessage.getPayload());
                break;
            case QUIT:
                finished = true;
                System.exit(0);
                break;
            case GAME_STARTED:
                started = true;
                break;
            case NEW:
                started = false;
                if (!Objects.isNull(gameArena)) {
                    EventBus.getInstance().unsubscribe(gameArena, Topics.GAME_STATE);
                }
                gameArena = null;
                break;
            case GAME_FINISHED:
                GameStateMessage gameStateMessage = (GameStateMessage) message;
                String payLoad = (String) gameStateMessage.getPayload();
                if (payLoad.equals("won")) {
                    DisplayEngine.getDisplay().displayInGreen("\n You won the game.");
                } else {
                    DisplayEngine.getDisplay().displayInGreen("\n You lost the game.");
                }
                started = false;
                EventBus.getInstance().unsubscribe(gameArena, Topics.GAME_STATE);
                gameArena = null;
                break;
            default:
                break;

        }
    }

    public static void reset() {
        started = false;
        isDebug = false;
        gameArena = null;
    }
}
