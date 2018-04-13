package in.ashwanik.clgame;


import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.impl.ConsoleDisplay;
import in.ashwanik.clgame.utils.SerializationUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static String filePath = "test.ser";

    private static GameArena getGameArena(boolean load) {
        GameArena gameArena = null;
        if (load) {
            gameArena = (GameArena) SerializationUtil.deserialize(filePath);
            return gameArena;
        } else {
            gameArena = new GameArena();
            gameArena.setPlayer(new Player(10));
            return gameArena;
        }
    }

    private static void init() {
        EventBus.init(new Broker());
        DisplayEngine.init(new ConsoleDisplay());
        CommandList.initCommands();
    }

    public static void main(String[] args) {
        init();
        Game game = new Game(getGameArena(false));
        game.start();
    }
}
