package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class LongSword extends Weapon implements Serializable {
    public LongSword(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
