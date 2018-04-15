package in.ashwanik.clgame.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Armoury {
    private static Armoury INSTANCE;
    private List<Weapon> weapons;

    private Armoury() {

    }

    public static Armoury get() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Armoury is not ready");
        }
        return INSTANCE;
    }

    public static void fill() {
        Armoury armoury = new Armoury();
        INSTANCE = armoury;
        armoury.weapons = new ArrayList<>();
        armoury.weapons.add(new Dagger("dagger", "Useful for short range attacks", 50, 5, 20));
        armoury.weapons.add(new LongSword("long sword", "Useful for long range attacks", 150, 20, 40));
        armoury.weapons.add(new Mace("mace", "Good for brutal attacks", 250, 25, 50));
        armoury.weapons.add(new SpikeHammer("spike hammer", "Good for brutal attacks", 300, 30, 50));
        armoury.weapons.add(new SpineSlasher("spine slasher", "Powerful attacks", 300, 40, 60));
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public int numberOfWeapons() {
        return this.weapons.size();
    }
}
