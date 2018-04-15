package in.ashwanik.clgame.models;

import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.CollectionsUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

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

    public boolean isDead() {
        return health == 0;
    }

    public boolean hasWeapon() {
        return !CollectionsUtil.isEmpty(weapons);

    }

    public void attack(Character character) {
        if (hasWeapon()) {
            Weapon weapon = getWeapons().get(0);
            Random random = new Random();
            int damage = random.nextInt(weapon.getMaximumDamage() + weapon.getMinimumDamage()) + weapon.getMinimumDamage();
            DisplayEngine.getDisplay().displayInWhite("\n\t" + this.getName() + " attacked " + character.getName() + " with " + weapon.getName());
            character.changeHealth(-damage);
        }
    }

    public void changeHealth(int delta) {

    }
}
