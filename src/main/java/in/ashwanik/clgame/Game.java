package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.CommandExecutor;
import in.ashwanik.clgame.commands.CommandParser;
import in.ashwanik.clgame.commands.IssuedCommand;
import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.Renderer;
import in.ashwanik.clgame.ui.screens.impl.WelcomeScreen;
import lombok.Getter;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
@Getter
public class Game implements Subscriber {
    private static GameArena gameArena;
    private CommandParser commandParser;
    private boolean finished;

    public Game(GameArena ga) {
        gameArena = ga;
        EventBus.getInstance().subscribe(this, Topics.GAME_STATE);
        commandParser = new CommandParser();
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
        DisplayEngine.getDisplay().display(Color.YELLOW, "Good bye, see you soon!!!");
        finished = true;
    }
}
