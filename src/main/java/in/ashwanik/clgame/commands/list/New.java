package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.models.Armoury;
import in.ashwanik.clgame.models.Weapon;
import in.ashwanik.clgame.ui.DisplayEngine;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class New extends Command {

    public New(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        DisplayEngine.getDisplay().displayInGreen("\nCreate a new character. Give some weapons to your character.\n");
        int index = 1;
        for (Weapon weapon : Armoury.get().getWeapons()) {
            DisplayEngine.getDisplay().displayInWhite(index + ". " + weapon.toString() + "\n");
            index++;
        }
        DisplayEngine.getDisplay().displayInGreen("\nRun arm command to create a new character\n");
        EventBus.getInstance().publish(GameStateMessage.builder().messageType(MessageType.NEW).topic(Topics.GAME_STATE).build());
    }
}
