package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZombieCreator {
    public static List<Zombie> createZombies(int numberOfZombies){
        Random random = new Random();
        List<Zombie> zombies = new ArrayList<>();
        while(numberOfZombies > 0){
            Zombie z = new Zombie(new Location(random.nextInt(6),random.nextInt(6)));
            zombies.add(z);
            numberOfZombies--;
        }
        return zombies;
    }
}
