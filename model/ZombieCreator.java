package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieCreator {
    public static List<Movable> createZombies(int numberOfZombies){
        Random random = new Random();
        List<Movable> zombies = new ArrayList<>();
        while(numberOfZombies > 0){
            Movable z = new Zombie(new Location(random.nextInt(6),random.nextInt(6)));
            zombies.add(z);
            numberOfZombies--;
        }
        return zombies;
    }
}
