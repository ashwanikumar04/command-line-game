package in.ashwanik.clgame.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class Orc extends Enemy implements Serializable {
    private static final long serialVersionUID = 425121681855996235L;

    public Orc(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }

}
