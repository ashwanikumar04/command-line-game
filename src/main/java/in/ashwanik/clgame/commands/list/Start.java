package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.ui.DisplayEngine;

import java.util.Objects;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Start extends Command {

    public Start(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (Objects.isNull(Game.getGameArena())) {
            DisplayEngine.getDisplay().displayInRed("Please set a character");
            return;
        }
        EventBus.getInstance().publish(GameStateMessage.builder().messageType(MessageType.GAME_STARTED).topic(Topics.GAME_STATE).build());
    }
}
