package in.ashwanik.clgame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Ashwani Kumar on 15/04/18.
 */
public class EnemyFactory {
    private List<Enemy> enemies;
    private Random random;
    private static EnemyFactory INSTANCE;

    private EnemyFactory() {
        enemies = new ArrayList<>();
        random = new Random();
        enemies.add(new Orc("Orc", "A deadly orc", 100, Collections.singletonList(Armoury.get().getWeapons().get(random.nextInt(Armoury.get().numberOfWeapons())))));
        enemies.add(new Uruk("Uruk", "A deadly uruk", 100, Collections.singletonList(Armoury.get().getWeapons().get(random.nextInt(Armoury.get().numberOfWeapons())))));
        enemies.add(new DarkElve("DarkElve", "A deadly dark elve", 100, Collections.singletonList(Armoury.get().getWeapons().get(random.nextInt(Armoury.get().numberOfWeapons())))));
    }

    public static void init() {
        INSTANCE = new EnemyFactory();
    }

    public static Enemy getEnemy() {
        EnemyFactory enemyFactory = INSTANCE;
        return new Enemy(enemyFactory.enemies.get(enemyFactory.random.nextInt(enemyFactory.enemies.size())));
    }

}
