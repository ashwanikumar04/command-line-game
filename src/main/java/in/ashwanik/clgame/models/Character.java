package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Character implements Serializable {
    private static final long serialVersionUID = 2166181694916422504L;
    private String name;
    private String description;
    private List<Weapon> weapons;
    private int health;


    public Character(String name, String description, int health, List<Weapon> weapons) {
        this.name = name;
        this.description = description;
        this.weapons = weapons;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
