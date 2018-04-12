package in.ashwanik.clgame;


import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.ui.screens.GameArena;
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

    public static void main(String[] args) {
        EventBus.init(new Broker());
        Game game = new Game(getGameArena(true));
        game.start();
    }
}
