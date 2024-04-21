package model;

public class Barbie implements Movable{
    private int health;
    private Location loc;

    // Constructrs Barbie object. 
    public Barbie(int health,Location loc){
        this.health = health;
        this.loc = loc;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int n){
        health = n;
    }
    // method for increasing or decreasing Barbies health.
    public void editHealth(int n){
        health = health + n;
    }
    @Override
    public void move(int row, int col) {
       loc.move(row, col);
    }
    @Override
    public Location getLocation() {
        return loc;
    }

    
   

    
}
