package in.ashwanik.clgame.ui.screens;

import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.GameStateMessage;
import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.messaging.messages.MessageType;
import in.ashwanik.clgame.models.EnemyFactory;
import in.ashwanik.clgame.models.Player;
import in.ashwanik.clgame.models.Room;
import in.ashwanik.clgame.ui.DisplayEngine;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class GameArena implements Serializable, Subscriber {
    private static final long serialVersionUID = -6158956787090431591L;
    private Player player;

    private int minimumEnemiesToKill;

    private int killedEnemies;
    private Room currentRoom;

    public GameArena(int minimumEnemiesToKill) {
        initializeArena();
        this.minimumEnemiesToKill = minimumEnemiesToKill;
    }

    private void initializeArena() {

        Room cell1 = new Room("cell1", "This is cell 1", false);
        Room cell2 = new Room("cell2", "This is cell 2", false);
        Room mainHall = new Room("mainHall", "This is main hall", false);
        Room ground = new Room("ground", "This is ground", true);


        cell1.setEnemy(EnemyFactory.getEnemy());
        cell2.setEnemy(EnemyFactory.getEnemy());
        mainHall.setEnemy(EnemyFactory.getEnemy());


        cell1.setExit("west", cell2);
        cell1.setExit("south", mainHall);

        cell2.setExit("east", cell1);
        cell2.setExit("south", mainHall);

        mainHall.setExit("north", cell1);
        mainHall.setExit("south", ground);

        currentRoom = cell1;
    }

    public void updateDisplay() {
        displayPlayerHud();
        displayEnemyHud();
        displayDirections();
    }

    private void displayDirections() {
        DisplayEngine.getDisplay().displayInGreen("\n");
        DisplayEngine.getDisplay().displayInGreen("\n\tCurrently in: " + currentRoom.getName());
        DisplayEngine.getDisplay().displayInWhite("\n\tE (" + currentRoom.getDisplayExit("east") + ")");
        DisplayEngine.getDisplay().displayInWhite("\tN (" + currentRoom.getDisplayExit("north") + ")");
        DisplayEngine.getDisplay().displayInWhite("\tS (" + currentRoom.getDisplayExit("south") + ")");
        DisplayEngine.getDisplay().displayInWhite("\tW (" + currentRoom.getDisplayExit("west") + ")");
    }

    private void displayPlayerHud() {
        if (player != null) {
            DisplayEngine.getDisplay().displayInGreen("\n\tPlayer health: " + player.getHealth());
            DisplayEngine.getDisplay().displayInGreen("\n\tPlayer Xp: " + player.getExperience());
            DisplayEngine.getDisplay().displayInGreen("\n\tEnemies Killed: " + killedEnemies);
            DisplayEngine.getDisplay().displayInGreen("\n");
        }
    }

    private void displayEnemyHud() {
        if (currentRoom.getEnemy() != null) {
            DisplayEngine.getDisplay().displayInGreen("\n\tEnemy Name: " + currentRoom.getEnemy().getName());
            DisplayEngine.getDisplay().displayInGreen("\n\tEnemy health: " + currentRoom.getEnemy().getHealth());
        }
    }


    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        currentRoom.setPlayer(player);
    }

    public int getMinimumEnemiesToKill() {
        return this.minimumEnemiesToKill;
    }

    public void setMinimumEnemiesToKill(int minimumEnemiesToKill) {
        this.minimumEnemiesToKill = minimumEnemiesToKill;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public void receive(Message message) {
        switch (message.getMessageType()) {
            case GAME_STARTED:
                updateDisplay();
                break;
            case ROOM_CHANGE:
                String direction = (String) ((GameStateMessage) message).getPayload();
                Room newRoom = currentRoom.getExit(direction);
                if (Objects.isNull(newRoom)) {
                    DisplayEngine.getDisplay().displayInRed("\n\tThere is no exit in this direction");
                    return;
                }
                if (newRoom.isLast()) {
                    if (killedEnemies >= minimumEnemiesToKill) {
                        EventBus.getInstance().publish(GameStateMessage.builder().topic(Topics.GAME_STATE).messageType(MessageType.GAME_FINISHED).payload("won").build());
                        return;
                    } else {
                        DisplayEngine.getDisplay().displayInRed("\n" + String.format("You have to kill at least %d enemies, you have killed %d", minimumEnemiesToKill, killedEnemies));
                        return;
                    }
                }
                newRoom.setPlayer(player);
                currentRoom.setPlayer(null);
                currentRoom = newRoom;
                updateDisplay();
                break;
            case GAME_FINISHED:
                break;
            case ENEMY_KILLED:
                killedEnemies++;
                break;
            case COMBAT:
                updateDisplay();
                break;
            default:
                break;
        }
    }
}
