package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private Barbie barbie;
    private ArrayList<Zombie> zombies;
    private ArrayList<Pear> pears;
    private int size = 5; // size for our square map.

    public Game(){
        // creating the objects.
        this.zombies = new ArrayList<Zombie>();
        this.pears = new ArrayList<Pear>();
        this.barbie = new Barbie(size, 2, 2);
        zombies.add(new Zombie(0,0));
        zombies.add(new Zombie(0,4));
        zombies.add(new Zombie(4,0));
        zombies.add(new Zombie(4,4));
        pears.add(new Pear(0,4));
        pears.add(new Pear(1,1));
        pears.add(new Pear(2,3));
        pears.add(new Pear(3,0));
        pears.add(new Pear(4,2));
    }
    // prints the location of barbies and zombies 
    public void reportLocations(){
        barbie.printLocation();
        for(int i = 0; i < zombies.size(); i++){
            zombies.get(i).printLocation();
        }
    }
    // prints the location of the pears.
    public void reportPears(){
        for(int i = 0; i < pears.size();i++){
            pears.get(i).printLocation();
        }
    }
    // prints Barbie's health
    public void reportHealth(){
        int health = barbie.getHealth();
        System.out.println("Barbie's health = " + health);
    }
    // method for checking if there are zombies around after each user move.
    public void checkZombies(){
        int col = barbie.getCol();
        int row = barbie.getRow();
        for(Zombie z : zombies){
            if((col == z.getCol()) & (row == z.getRow())){
                barbie.setHealth(0);
            }
            if((col == z.getCol()) & (row-1 == z.getRow())){
                barbie.editHealth(-1);
            }if((col == z.getCol()) & (row+1 == z.getRow())){
                barbie.editHealth(-1);
            }if((row == z.getRow()) & (col-1 == z.getCol())){
                barbie.editHealth(-1);
            }if((row == z.getRow()) & (col+1 == z.getCol())){
                barbie.editHealth(-1);
            }
        }
    }
    // prints welcome message.
    public void printWelcome(){
        System.out.println("\nWelcome to Barbie vs Zombies!!!!!");
        System.out.println("In this game,you are a Barbie.Barbie is in a 5x5 grid, with four Zombies and five Pears.");
        System.out.println("Zombie's are located on the four corners of the map.");
        System.out.println("And for the first version of this game, pears are located on the same spot every time.");
        System.out.println("If zombies are next to Barbie, she loses one health.");
        System.out.println("If Barbie steps on a pear, she gains one health.");
        System.out.println("If you step on the same grid with a zombie, you die instantly!");
        System.out.println("Barbie starts the game in the middle of the map.");
        System.out.println("Here are the Locations of Everyone : ");
        reportLocations();
        reportPears();
        System.out.println("\nYou have four different commands: 'up', 'down', 'left', 'right'.");
        System.out.println("If you try leaving the game zone,or enter a wrong command, you can't move. But zombies will. Be careful!");
        System.out.println("Collect all the pears before zombies eat your brains! Good Luck!");
    }
    // starts the game. Loop continues until processCommand method returns true value.
    public void play(){
        printWelcome();
        Scanner reader = new Scanner(System.in);
        boolean finished = false;
        while(!finished){
            System.out.print(" > ");
            String command = reader.next();
            finished = processCommand(command);
        }
        reader.close();
        System.out.println("Thank you for Playing Barbie vs Zombies. GoodBye!");
    }
    // processCommand method for taking the user input, and processing the command to make the move, check the health, and check if the game is won or lost.
    // return true if the game is won or lost, return false if game needs to process.
    private boolean processCommand(String command){
        barbie.move(command);
        for(Zombie z : zombies){
            z.move();
        }
        // dummy pear for removing the pear after the loop, if any pear is picked up.
        Pear picked = new Pear();
        // checking if any pears on the map is on the same square with barbie. 
        for(Pear p : pears){
            if((barbie.getCol() == p.getCol()) & (barbie.getRow() == p.getRow())){
                System.out.println("Pear Picked Up");
                barbie.editHealth(+1);
                picked = p;
            }
        }if(pears.contains(picked)){
            pears.remove(picked);
        }
        // I check the surroundings after the pear is picked, to avoid user health going <= 0.
        checkZombies();
        if(barbie.isDead()){
            System.out.println("Barbie died.");
            return true;
        }
        reportLocations();
        reportHealth();
        if(!pears.isEmpty()){
            reportPears();
        } else{
            System.out.println("Collected all the pears. You Win!!!");
            return true;
        }
        return false;

        
    }   
    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.play();
    }

}
