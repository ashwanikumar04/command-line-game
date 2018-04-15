package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Enemy extends Character implements Serializable {
    private static final long serialVersionUID = -8785535851108263852L;
    private int experience;

    public Enemy(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
        experience = health;
    }

    public Enemy(Enemy enemy) {
        super(enemy.getName(), enemy.getDescription(), enemy.getHealth(), enemy.getWeapons());
        experience = enemy.getHealth();
    }

    @Override
    public void changeHealth(int delta) {
        int change = getHealth() + delta;
        if (change < 0) {
            change = 0;
        }
        setHealth(change);
    }

    public int getExperience() {
        return experience / 10;
    }

}
