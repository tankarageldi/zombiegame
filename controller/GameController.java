package controller;
// GameController class
import views.GameView;

import java.util.Random;

import model.Barbie;
import model.Board;
import model.Zombie;
public class GameController {
    private Board gameBoard;
    private GameView gameView;

    public GameController(Board gameBoard, GameView gameView) {
        this.gameBoard = gameBoard;
        this.gameView = gameView;
    }

    public void runGame() {
        while (!gameBoard.isWinner() && !gameBoard.isLost()) {
            gameView.display();
            String input = gameView.getUserInput();

            // Parse input and update player position accordingly
            updatePlayerPosition(input);
            updateZombies();

            // Update game board state
            gameBoard.update();
        }

        // Display final game result
        if (gameBoard.isWinner()) {
            System.out.println("Congratulations! You collected all the pears and won the game!");
        } else if (gameBoard.isLost()) {
            System.out.println("Game over! You lost all your health.");
        }
    }

    // Method to update player position based on user input
    private void updatePlayerPosition(String input) {
        Barbie player = gameBoard.getBarbie();

        // Define the movement based on input
        int dx = 0, dy = 0;
        switch (input) {
            case "w": // Move up
                dy = -1;
                break;
            case "s": // Move down
                dy = 1;
                break;
            case "a": // Move left
                dx = -1;
                break;
            case "d": // Move right
                dx = 1;
                break;
            default:
                System.out.println("Invalid input. Please enter 'w', 'a', 's', or 'd'.");
                return;
        }

        // Move the player
        player.move(dx, dy);
    }
    public void updateZombies(){
        Random random = new Random();
        for (Zombie zombie : gameBoard.getZombies()){
            zombie.move(random.nextInt(1),random.nextInt(1));
        }
    }
}
