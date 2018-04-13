package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Weapon extends CollectibleItem implements Serializable {
    private static final long serialVersionUID = 6185237117225847964L;
    private int minimumDamage;
    private int maximumDamage;

    public Weapon(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight);
        this.maximumDamage = maximumDamage;
        this.minimumDamage = minimumDamage;
    }

    public int getMinimumDamage() {
        return this.minimumDamage;
    }

    public int getMaximumDamage() {
        return this.maximumDamage;
    }

    public String toString() {
        return "name: " + getName()
                + ", description: " + getDescription()
                + ", minimumDamage: " + this.getMinimumDamage()
                + ", maximumDamage:" + this.getMaximumDamage()
                + ", weight: " + this.getWeight() + " g";
    }
}
