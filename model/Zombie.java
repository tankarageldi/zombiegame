package model;

public class Zombie implements Movable{
    private Location loc;

    Zombie(Location loc){
        this.loc = loc;
    }
    @Override
    public void move(int row, int col) {
        loc.move(row,col);
    }
    @Override
    public Location getLocation() {
        return loc;
    }
     
    
}
