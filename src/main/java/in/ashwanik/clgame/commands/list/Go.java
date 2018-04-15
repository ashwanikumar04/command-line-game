package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.ui.DisplayEngine;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Go extends Command {

    public Go(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (!Game.isStarted()) {
            DisplayEngine.getDisplay().display(Color.RED, "\nGame has not started?");
            return;
        }
        if (arguments.length == 0) {
            DisplayEngine.getDisplay().display(Color.RED, "\nGo where?\n");
            return;
        }
        EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.ROOM_CHANGE).payload(arguments[0]).build());
    }
}
