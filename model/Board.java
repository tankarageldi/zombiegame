package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Movable barbie;
    private List<Movable> zombies;
    private List<Pear> pears;

    public Board(){
        Movable barbie = new Barbie(5, new Location(0, 0));
        zombies = ZombieCreator.createZombies(4);
        pears = PearCreator.createPears(4);
    }

    public void update(){
        
    }
    public boolean isLost(){
        return pears.isEmpty();
    }
    public boolean isWinner(){
        return pears.isEmpty();
    }
    public Movable getBarbie(){
        return barbie;
    }
    public List<Movable> getZombies(){
        return zombies;
    }
    public List<Pear> getPears(){
        return pears;
    }
    // Helper method to check if two locations are adjacent
    private boolean isAdjacent(Location loc1, Location loc2) {
        int dx = Math.abs(loc1.getRow() - loc2.getRow());
        int dy = Math.abs(loc1.getCol() - loc2.getCol());
        return dx <= 1 && dy <= 1;
    }


    
}
