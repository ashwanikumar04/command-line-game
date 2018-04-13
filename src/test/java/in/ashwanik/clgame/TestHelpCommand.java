package in.ashwanik.clgame;

import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.ui.screens.GameDisplay;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.experimental.categories.Category;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Category(UnitTest.class)
public class TestHelpCommand {

    private List<String> messages;
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    private InputStream inputStream;
    private GameDisplay gameDisplay;

    private void init() {
        messages = new ArrayList<>();
        gameDisplay = new GameDisplay() {
            @Override
            public void displayInWhite(String text) {
                messages.add(text);
            }

            @Override
            public void displayInRed(String text) {
                messages.add(text);
            }

            @Override
            public void displayInGreen(String text) {
                messages.add(text);
            }

            @Override
            public void display(Color color, String text) {
                messages.add(text);
            }
        };
    }

    @Before
    public void setup() {
        init();
        inputStream = System.in;

    }

    @Test
    public void Should_Run_Help() {
        systemInMock.provideLines("help", "Quit");
        Application.startGame(inputStream, gameDisplay);
        assertThat(messages.size()).isEqualTo(13);
    }
}

