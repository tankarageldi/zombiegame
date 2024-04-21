package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PearCreator {
    public static List<Pear> createPears(int numberOfPears){
        Random random = new Random();
        List<Pear> pears = new ArrayList<>();
        while(numberOfPears > 0){
            Pear p = new Pear(new Location(random.nextInt(6),random.nextInt(6)));
            pears.add(p);
            numberOfPears--;
        }
        return pears;
    }
}