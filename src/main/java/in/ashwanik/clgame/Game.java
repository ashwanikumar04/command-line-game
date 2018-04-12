package in.ashwanik.clgame;

import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Message;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;
import in.ashwanik.clgame.ui.screens.Renderer;
import in.ashwanik.clgame.ui.screens.impl.WelcomeScreen;
import in.ashwanik.clgame.utils.SerializationUtil;
import lombok.Getter;

import java.util.Scanner;

/**
 * Created by Ashwani Kumar on 11/04/18.
 */
@Getter
public class Game {
    private static final long serialVersionUID = -3944652744199321295L;
    private Scanner reader;
    private static GameArena gameArena;

    public Game(GameArena gameArena) {
        EventBus.getInstance().subscribe(gameArena, "topic");
        reader = new Scanner(System.in);
    }

    public void start() {
        Renderer welcomeRenderer = new WelcomeScreen();
        welcomeRenderer.render();
        boolean finished = false;
        gameArena.updateDisplay();
        while (!finished) {
            String inputLine;   // will hold the full input line
            String word1 = null;
            String word2 = null;

            DisplayEngine.getDisplay().displayInGreen("> ");     // print prompt
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
                SerializationUtil.serialize(Application.filePath, gameArena);
                finished = true;
            } else if (word1.equals("publish")) {
                EventBus.getInstance().publish(Message.builder().payload("test").topic("topic").build());
            }
        }

    }


}
