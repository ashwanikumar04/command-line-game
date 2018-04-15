package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Ashwani Kumar on 15/04/18.
 */

public class Room implements Serializable {
    private static final long serialVersionUID = -3644969056565784200L;
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private Enemy enemy;
    private boolean isLast;

    private Player player;

    public Room(String name, String description, boolean isLast) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
        enemy = null;
        this.isLast = isLast;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean hasEnemy() {
        return this.enemy != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setExit(String description, Room neighbour) {
        exits.put(description, neighbour);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getDisplayExit(String direction) {
        return Objects.isNull(exits.get(direction)) ? "NA" : exits.get(direction).name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isLast() {
        return this.isLast;
    }
}
