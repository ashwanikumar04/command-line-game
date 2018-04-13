package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.messaging.messages.QuitMessage;

/**
 * Created by jh80 on 13/04/18.
 */
public class Quit extends Command {

    public Quit(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        EventBus.getInstance().publish(QuitMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.GAME_STATE).build());
    }
}
