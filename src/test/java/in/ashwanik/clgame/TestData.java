package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.CommandList;
import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.models.EnemyFactory;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameDisplay;

import java.util.List;

/**
 * Created by Ashwani Kumar on 15/04/18.
 */
class TestData {
    public static class TestDisplay implements GameDisplay {
        private List<String> messages;

        TestDisplay(List<String> messages) {
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


    static void initBaseData(List<String> messages) {
        EventBus.init(new Broker());
        DisplayEngine.init(new TestData.TestDisplay(messages));
        CommandList.initCommands();
        Armoury.fill();
        EnemyFactory.init();
    }
}
