package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class HealingPortion extends CollectibleItem implements Serializable {

    private int healingValue;

    public HealingPortion(String name, String description, int weight, int healingValue) {
        super(name, description, weight);
        this.healingValue = healingValue;
    }

    public int getHealingValue() {
        return this.healingValue;
    }
}
