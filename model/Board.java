package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Barbie barbie;
    private List<Zombie> zombies;
    private List<Pear> pears;

    public Board(){
        barbie = new Barbie(5, new Location(0, 0));
        zombies = ZombieCreator.createZombies(4);
        pears = PearCreator.createPears(4);
    }

    public void update(){
        check();
    }
    public boolean isLost(){
        return barbie.getHealth() <= 0;
    }
    public boolean isWinner(){
        return pears.isEmpty();
    }
    public Barbie getBarbie(){
        return barbie;
    }
    public List<Zombie> getZombies(){
        return zombies;
    }
    public List<Pear> getPears(){
        return pears;
    }
    // Helper method to check if two locations are adjacent
    public boolean isAdjacent(Location loc1, Location loc2) {
        int dx = Math.abs(loc1.getRow() - loc2.getRow());
        int dy = Math.abs(loc1.getCol() - loc2.getCol());
        return dx <= 1 && dy <= 1;
    }
    private void checkCollisions(){
         // Check for player-zombie collisions
         for (Zombie zombie : zombies) {
            if (isAdjacent(barbie.getLocation(), zombie.getLocation())) {
                barbie.setHealth(barbie.getHealth() - 1);
            }
        }
    }
    private void checkPears(){
        // Check for player-pear collection
        List<Pear> collectedPears = new ArrayList<>();
        for (Pear pear : pears) {
            if (barbie.getLocation().equals(pear.getLocation())) {
                barbie.setHealth(barbie.getHealth() + 1);
                collectedPears.add(pear);
            }
        }
        // Remove collected pears
        pears.removeAll(collectedPears);
    }
    public void check(){
        checkCollisions();
        checkPears();
    }


    
}
