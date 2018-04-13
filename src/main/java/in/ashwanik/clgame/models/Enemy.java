package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Enemy extends Character implements Serializable {
    private static final long serialVersionUID = -8785535851108263852L;

    public Enemy(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }
}
