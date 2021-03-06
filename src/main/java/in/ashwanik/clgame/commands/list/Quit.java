package in.ashwanik.clgame.commands.list;

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
public class Quit extends Command {

    public Quit(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        DisplayEngine.getDisplay().display(Color.YELLOW, "Good bye, see you soon!!!\n");
        EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.QUIT).build());
    }
}
