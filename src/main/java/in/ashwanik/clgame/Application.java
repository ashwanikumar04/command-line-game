package in.ashwanik.clgame;


import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.commands.CommandParser;
import in.ashwanik.clgame.commands.InputStreamCommandParser;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.models.EnemyFactory;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameDisplay;
import in.ashwanik.clgame.ui.screens.impl.ConsoleDisplay;

public class Application {


    public static void main(String[] args) {
        startGame(new InputStreamCommandParser(System.in), new ConsoleDisplay(), false);
    }

    public static Game startGame(CommandParser commandParser, GameDisplay gameDisplay, boolean processSingleCommand) {
        init(gameDisplay);
        Game game = new Game(commandParser);
        game.start(processSingleCommand);
        return game;
    }

    private static void init(GameDisplay gameDisplay) {
        EventBus.init(new Broker());
        DisplayEngine.init(gameDisplay);
        CommandList.initCommands();
        Armoury.fill();
        EnemyFactory.init();
    }
}
