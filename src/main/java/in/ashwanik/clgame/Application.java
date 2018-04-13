package in.ashwanik.clgame;


import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameDisplay;
import in.ashwanik.clgame.ui.screens.impl.ConsoleDisplay;

import java.io.InputStream;

public class Application {


    public static void main(String[] args) {
        startGame(System.in, new ConsoleDisplay());
    }

    public static void startGame(InputStream inputStream, GameDisplay gameDisplay) {
        init(gameDisplay);
        Game game = new Game(inputStream);
        game.start();
    }

    private static void init(GameDisplay gameDisplay) {
        EventBus.init(new Broker());
        DisplayEngine.init(gameDisplay);
        CommandList.initCommands();
        Armoury.fill();
    }
}
