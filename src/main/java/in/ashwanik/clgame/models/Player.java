package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class Player extends Character implements Serializable {
    private static final long serialVersionUID = 425121681855996235L;

    private int experience;

    public Player(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
        experience = 100;
    }


    @Override
    public void changeHealth(int delta) {
        int change = getHealth() + delta;
        if (change < 0) {
            change = 0;
        } else if (change > 100) {
            change = 100;
        }
        setHealth(change);
    }

    public void increaseXp(int change) {
        experience += change;
    }

    public int getExperience() {
        return this.experience;
    }
}
