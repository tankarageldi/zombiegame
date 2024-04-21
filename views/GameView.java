package views;

// GameView class
import java.util.Scanner;

import model.Board;
import model.Location;
import model.Pear;
import model.Zombie;

public class GameView {
    private Board board;

    public GameView(Board board) {
        this.board = board;
    }

    // Display the game state
    public void display() {
        char [][] grid = createGrid();
        placeBarbie(grid);
        placeZombies(grid);
        placePears(grid);
        displayGrid(grid);
        // Display additional game information (e.g., player's health)
        System.out.println("Player Health: " + board.getBarbie().getHealth());
    }
    private void displayGrid(char[][] grid){
        // Display the grid
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    private char[][] createGrid(){
        // Create a 5x5 grid filled with empty spaces (e.g., '.')
        char[][] grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }
        return grid;
    }
    private void placeBarbie(char[][] grid){
        // Place the player on the grid
        Location playerLocation = board.getBarbie().getLocation();
        grid[playerLocation.getCol()][playerLocation.getRow()] = 'B';
    }
    private void placeZombies(char[][] grid){
         // Place the zombies on the grid
         for (Zombie zombie : board.getZombies()) {
            Location zombieLocation = zombie.getLocation();
            grid[zombieLocation.getCol()][zombieLocation.getRow()] = 'Z';
        }
    }
    private void placePears(char[][] grid){
         // Place the pears on the grid
         for (Pear pear : board.getPears()) {
            Location pearLocation = pear.getLocation();
            grid[pearLocation.getCol()][pearLocation.getRow()] = 'o';
        }
    }

    // Get user input for player movement (e.g., 'w', 'a', 's', 'd')
    public String getUserInput() {
        try (// Read user input (e.g., from console)
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your move (w/a/s/d): ");
            return scanner.nextLine();
        }
    }
}
