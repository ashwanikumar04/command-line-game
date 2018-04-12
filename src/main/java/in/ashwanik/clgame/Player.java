package in.ashwanik.clgame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Getter
@Setter
@AllArgsConstructor
public class Player implements Serializable {
    private static final long serialVersionUID = 425121681855996235L;
    private int health;
}
