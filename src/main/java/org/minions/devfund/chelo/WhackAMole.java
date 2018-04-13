package org.minions.devfund.chelo;

import java.util.Random;
import java.util.Scanner;

/**
 * A class for WackAMole task.
 */
public class WhackAMole {
    private int score, molesLeft, attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
     * @param numAttempts initial tries for the user.
     * @param gridDimension size of the grid.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.molesLeft = gridDimension;
        placeTheMoles(this.molesLeft, gridDimension);
    }

    /**
     * A method to randomically put the moles in the grid.
     * @param molesLeft remaining moles
     * @param dimensionLimit dimension of the grid's limit
     */
    private void placeTheMoles(int molesLeft, int dimensionLimit) {
        int x, y;
        Random rand = new Random();

        while (molesLeft > 0) {
            x = rand.nextInt(dimensionLimit);
            y = rand.nextInt(dimensionLimit);
            if (place(x, y)) {
                molesLeft--;
            }
        }
    }

    /**
     * Method given a location, place a mole at that location.
     * @param x coordinate
     * @param y coordinate
     * @return status of the grid
     */
    private boolean place(int x, int y) {
        if (this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method given a location, take a whack at that location.
     * If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated.
     * If that location does not contain a mole, only attemptsLeft is updated.
     * @param x coordinate
     * @param y coordinate
     */
    public void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            molesLeft--;
            attemptsLeft--;
        } else {
            if (moleGrid[x][y] == 'o' || moleGrid[x][y] == 'W') {
                System.out.println("Position already hit");
            } else {
                moleGrid[x][y] = 'o';
                attemptsLeft--;
            }
        }
    }

    /**\
     * A method to return Attempts Left value.
     * @return remaining attempts
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * A method to return moles left value.
     * @return remaining moles
     */
    public int getMolesLeft() {
        return  molesLeft;
    }

    /**
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     */
     public void printGridToUser() {
         for (int i = 0; i < moleGrid.length; i++) {
             for (int j = 0; j < moleGrid.length; j++) {
                 if (moleGrid[i][j] == 'M') {
                     System.out.print("[ ]");
                 } else {
                     System.out.print("[" + moleGrid[i][j] + "]");
                 }
             }
             System.out.println(" ");
         }
         printStatus();
     }

    /**
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     */
    public void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print("[" + moleGrid[i][j] + "]");
            }
            System.out.println(" ");
        }
        printStatus();
    }

    /**
     * A method to print the current status for.
     * Score,
     * Attempts Left,
     * Moles Left.
     */
    public void printStatus() {
        System.out.println("Score: " + this.score
                + ", Attempts left: " + this.attemptsLeft
                + ", Moles left: " + this.molesLeft);
    }

    /**
     * Main method to run the program.
     * @param args main method
     */
    public static void main(final String[] args) {
        int numAttempts = readUserInput();
        int dimensionBegin = readUserInput();
        WhackAMole whackAmole = new WhackAMole(numAttempts, dimensionBegin);

        // Printing the grid as first action to know where the moles were placed
        whackAmole.printGrid();

        int userInputX, userInputY;

        // While the attempts left are greater than zero the user can submit coordinates
        while (whackAmole.getAttemptsLeft() > 0) {
            if (whackAmole.getMolesLeft() == 0) {
                System.out.println("Whack-A-Mole CHAMP!!!");
                break;
            }

            // Reading user input
            System.out.println("Enter X: ");
            userInputX = readUserInput();
            System.out.println("Enter Y: ");
            userInputY = readUserInput();

            // Printint the coordinates submited by the user
            System.out.println("User input: [X=" + userInputX + "][Y=" + userInputY + "]");

            // Conditional if the user wants to finish the game
            if (userInputX == -1 && userInputY == -1) {
                whackAmole.printGrid();
                System.out.println("GAME OVER :(");
                break;
            }

            // Positioning the user's hit
            whackAmole.whack(userInputX, userInputY);
            whackAmole.printGridToUser();

            numAttempts--;

            if (numAttempts == 0) {
                whackAmole.printGrid();
                System.out.println("GAME OVER! NO MORE ATTEMPTS");
                break;
            }
        }
    }

    /**
     * A method to read user input and validate is a value between the range of array dimension.
     * Validates a valid integer too.
     * @return the integer value entered by the user.
     */
    public static int readUserInput() {
        Scanner scanner = new Scanner(System.in);

        String value; // Inner assignments should be avoided.
        while (!(value = scanner.next()).matches("^(-1?|^[0-9])$")) {
            System.out.print("Wrong input. Insert again: ");
        }
        return Integer.parseInt(value);
    }
}
