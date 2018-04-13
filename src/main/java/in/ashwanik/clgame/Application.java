package in.ashwanik.clgame;


import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.impl.ConsoleDisplay;

public class Application {
    private static void init() {
        EventBus.init(new Broker());
        DisplayEngine.init(new ConsoleDisplay());
        CommandList.initCommands();
    }

    public static void main(String[] args) {
        init();
        Game game = new Game();
        game.start();
    }
}
