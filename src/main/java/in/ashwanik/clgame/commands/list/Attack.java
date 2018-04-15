package in.ashwanik.clgame.commands.list;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.common.Color;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.models.Room;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.ui.screens.GameArena;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Attack extends Command {

    public Attack(String name, String info) {
        super(name, info);
    }

    @Override
    public void execute(String[] arguments) {
        if (!Game.isStarted()) {
            DisplayEngine.getDisplay().display(Color.RED, "\nGame has not started");
            return;
        }
        GameArena gameArena = Game.getGameArena();
        Room room = gameArena.getCurrentRoom();
        if (room.hasEnemy()) {
            room.getPlayer().attack(room.getEnemy());
            if (room.getEnemy().isDead()) {
                room.getPlayer().increaseXp(room.getEnemy().getExperience());
                room.setEnemy(null);
                EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.ENEMY_KILLED).build());
            }
            if (room.hasEnemy()) {
                room.getEnemy().attack(room.getPlayer());
            }
            if (room.getPlayer().isDead()) {
                EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.GAME_FINISHED).payload("lost").build());
                return;
            }
        } else {
            DisplayEngine.getDisplay().display(Color.YELLOW, "\nThere is no enemy to attack.");
            return;
        }
        EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.COMBAT).build());
    }
}
