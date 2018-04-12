package org.minions.devfund.roy;

import java.util.Random;
import java.util.Scanner;

/**
 * WhackAMole entity.
 */
public class WhackAMole {

    private char[][] grid;
    private int score;
    private int numberOfAttemptsLeft;
    private int molesLeft;
    private static final char MOLE = 'M';
    private static final char WHACKED_MOLE = 'W';
    private static final char EMPTY_PLACE = '*';
    private Scanner scanner;

    /**
     * Constructor.
     *
     * @param numAttempts   to start the game.
     * @param gridDimension to create the grid for the game.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        scanner = new Scanner(System.in, "UTF-8");
        this.grid = new char[gridDimension][gridDimension];
        numberOfAttemptsLeft = numAttempts;
        this.molesLeft = gridDimension;
        initializeGrid();
    }

    /**
     * Verifies if a place is empty or not.
     *
     * @param x axis position.
     * @param y axis position.
     * @return true if the place is empty otherwise false.
     */
    public boolean place(int x, int y) {
        try {
            if (grid[x][y] == EMPTY_PLACE) {
                grid[x][y] = MOLE;
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {

            return false;
        }
    }

    /**
     * Starts the grid with the moles.
     */
    public void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = EMPTY_PLACE;
            }
        }

        int moles = molesLeft;

        while (moles > 0) {
            int xRandomValue = new Random().nextInt(grid.length);
            int yRandomValue = new Random().nextInt(grid.length);

            if (place(xRandomValue, yRandomValue)) {
                moles--;
            }
        }
    }

    /**
     * Whacks a position received.
     *
     * @param x axis position.
     * @param y axis position.
     */
    public void whack(int x, int y) {
        if (!(x == y && y == -1) && numberOfAttemptsLeft > 0) {
            try {
                if (grid[x - 1][y - 1] == MOLE) {
                    grid[x - 1][y - 1] = WHACKED_MOLE;
                    score++;
                    numberOfAttemptsLeft--;
                    molesLeft--;
                    System.out.println("Attempts left: " + numberOfAttemptsLeft);
                } else {
                    numberOfAttemptsLeft--;
                    System.out.println("Attempts left: " + numberOfAttemptsLeft);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Wrong position");
            }
        } else {
            printGridAndScore();
        }
    }

    /**
     * Prints in console the Grid view por the user.
     */
    public void printGridToUser() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == MOLE) {
                    System.out.print(EMPTY_PLACE);
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints in console the grid.
     */
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Prints grind and the score on the console.
     */
    public void printGridAndScore() {
        printGrid();
        System.out.println("Score: " + score);
    }

    /**
     * Starts the game to play it.
     */
    public void playGame() {
        int varX = 0;
        int varY = 0;
        printGridToUser();
        while (numberOfAttemptsLeft > 0) {
            varX = scanner.nextInt();
            varY = scanner.nextInt();
            if (varX == varY && varX == -1) {
                whack(varX, varY);
                break;
            } else {
                whack(varX, varY);
            }
        }

        if (numberOfAttemptsLeft == 0) {
            printGridAndScore();
        }
    }
}
