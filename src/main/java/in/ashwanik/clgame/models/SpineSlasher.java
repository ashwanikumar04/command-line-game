package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class SpineSlasher extends Weapon implements Serializable {
    private static final long serialVersionUID = 8899606382744685587L;

    public SpineSlasher(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
