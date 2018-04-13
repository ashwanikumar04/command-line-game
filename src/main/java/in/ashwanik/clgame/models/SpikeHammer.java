package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class SpikeHammer extends Weapon implements Serializable {
    private static final long serialVersionUID = 1357475305567978168L;

    public SpikeHammer(String name, String description, int weight, int minimumDamage, int maximumDamage) {
        super(name, description, weight, minimumDamage, maximumDamage);
    }
}
