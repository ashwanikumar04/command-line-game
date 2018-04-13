package in.ashwanik.clgame.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class Player extends Character implements Serializable {
    private static final long serialVersionUID = 425121681855996235L;

    @Getter
    @Setter
    private int collectibleWeight;

    public Player(String name, String description, int health, List<Weapon> weapons) {
        super(name, description, health, weapons);
    }
}
