package in.ashwanik.clgame.models;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class CollectibleItem extends Item implements Serializable {

    private static final long serialVersionUID = -7595122313827713642L;
    private int weight;

    public CollectibleItem(String name, String description, int weight) {
        super(name, description);
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}
