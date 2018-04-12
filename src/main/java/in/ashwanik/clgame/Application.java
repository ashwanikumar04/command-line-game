package in.ashwanik.clgame;


import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.Messenger;
import in.ashwanik.clgame.ui.screens.ConsoleDisplay;
import in.ashwanik.clgame.ui.screens.GameArena;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Slf4j
public class Application {

    public static String filePath = "test.ser";

    private static GameArena getGameArena(boolean load) {
        GameArena gameArena = null;
        if (load) {
            try {
                FileInputStream fi = new FileInputStream(filePath);
                ObjectInputStream is = new ObjectInputStream(fi);
                gameArena = (GameArena) is.readObject();
                is.close();
                fi.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
                return null;
            }
            return gameArena;
        } else {
            gameArena = new GameArena();
            gameArena.setPlayer(new Player(10));
            return gameArena;
        }
    }

    public static void main(String[] args) {
        Messenger.init(new Broker());
        Game game = new Game(new ConsoleDisplay(), getGameArena(true));
        game.start();
    }
}
