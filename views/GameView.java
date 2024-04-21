package views;

import java.util.Scanner;
import model.Board;

public class GameView {
    private Board board;
    public GameView(Board board) {
        this.board = board;
    }
    public void display(){
        // Create a 5x5 grid filled with empty spaces (e.g., '.')
        char[][] grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = '.';
            }
        }
    }

}
