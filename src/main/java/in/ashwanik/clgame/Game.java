package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.CommandExecutor;
import in.ashwanik.clgame.commands.CommandParser;
import in.ashwanik.clgame.commands.IssuedCommand;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.Renderer;
import in.ashwanik.clgame.ui.screens.impl.WelcomeScreen;
import lombok.Getter;

import java.io.InputStream;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
public class Game implements Subscriber {
    private static GameArena gameArena;
    private CommandParser commandParser;
    private boolean finished;
    @Getter
    private static boolean started;

    public Game(InputStream inputStream) {
        EventBus.getInstance().subscribe(this, Topics.GAME_STATE);
        commandParser = new CommandParser(inputStream);
    }

    public static GameArena getGameArena() {
        return gameArena;
    }

    public static void setGameArena(GameArena ga) {
        EventBus.getInstance().subscribe(ga, Topics.GAME_STATE);
        gameArena = ga;
    }

    public void start() {
        Renderer welcomeRenderer = new WelcomeScreen();
        welcomeRenderer.render();
        finished = false;
        while (!finished) {
            IssuedCommand issuedCommand = commandParser.getIssuedCommand();
            CommandExecutor.execute(issuedCommand);
        }
    }

    @Override
    public void receive(Message message) {
        switch (message.getMessageType()) {
            case QUIT:
                finished = true;
                break;
            case GAME_STARTED:
                started = true;
                break;
            default:
                break;

        }
    }
}
