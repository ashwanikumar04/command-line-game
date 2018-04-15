package in.ashwanik.clgame;

import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.ui.screens.GameDisplay;

import java.util.List;

/**
 * Created by Ashwani Kumar on 15/04/18.
 */
public class TestData {


    public static class TestDisplay implements GameDisplay {
        private List<String> messages;

        public TestDisplay(List<String> messages) {
            this.messages = messages;

        }

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
    }

}
