package in.ashwanik.clgame;

import in.ashwanik.clgame.messaging.Message;
import in.ashwanik.clgame.messaging.Messenger;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.GameDisplay;
import in.ashwanik.clgame.ui.screens.Renderer;
import in.ashwanik.clgame.ui.screens.impl.WelcomeScreen;
import lombok.Getter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
@Getter
public class Game {
    private static final long serialVersionUID = -3944652744199321295L;
    private GameDisplay gameDisplay;
    private Scanner reader;
    private GameArena gameArena;

    public Game(GameDisplay gameDisplay, GameArena gameArena) {
        this.gameDisplay = gameDisplay;
        this.gameArena = gameArena;
        gameArena.setGameDisplay(gameDisplay);
        Messenger.getInstance().subscribe(gameArena, "topic");
        reader = new Scanner(System.in);
    }

    public void start() {
        Renderer welcomeRenderer = new WelcomeScreen(gameDisplay);
        welcomeRenderer.render();
        boolean finished = false;
        gameArena.updateDisplay();
        while (!finished) {
            String inputLine;   // will hold the full input line
            String word1 = null;
            String word2 = null;

            gameDisplay.displayInGreen("> ");     // print prompt
            inputLine = reader.nextLine();
            Scanner tokenizer = new Scanner(inputLine);
            if (tokenizer.hasNext()) {
                word1 = tokenizer.next();      // get first word
                if (tokenizer.hasNext()) {
                    word2 = tokenizer.next();      // get second word
                    // note: we just ignore the rest of the input line.
                }
            }
            if (word1.equals("save")) {
                save();
                finished = true;
            } else if (word1.equals("publish")) {
                Messenger.getInstance().publish(Message.builder().payload("test").topic("topic").build());
            }
        }

    }

    private void save() {
        FileOutputStream fo = null;
        ObjectOutputStream os = null;
        try {
            fo = new FileOutputStream(Application.filePath);
            os = new ObjectOutputStream(fo);
            os.writeObject(gameArena);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
