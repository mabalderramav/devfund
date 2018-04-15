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
    WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.molesLeft = 0;
        initializeGrid();
    }

    /**
     * A method to initialize the grid with asterisks.
     */
    void initializeGrid() {
        for (int i = 0; i < this.moleGrid.length; i++) {
            for (int j = 0; j < this.moleGrid.length; j++) {
                this.moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * A method to randomically put the moles in the grid.
     * @param molesLeft remaining moles
     * @param dimensionLimit dimension of the grid's limit
     */
    void placeTheMoles(int molesLeft, int dimensionLimit) {
        int x, y;
        Random rand = new Random();

        while (molesLeft > 0) {
            x = rand.nextInt(dimensionLimit);
            y = rand.nextInt(dimensionLimit);
            if (place(x, y)) {
                this.moleGrid[x][y] = 'M';
                molesLeft--;
            }
        }
    }

    /**
     * Method given a location, returns if availability.
     * @param x coordinate
     * @param y coordinate
     * @return status of the coordinate
     */
    boolean place(int x, int y) {
        if (this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
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
    void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            molesLeft--;
            attemptsLeft--;
        } else {
            attemptsLeft--;
        }
    }

    /**
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a whacked mole, print out a W, or * otherwise.
     */
    void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == 'M') {
                    System.out.print("[*]");
                } else {
                    System.out.print("[" + moleGrid[i][j] + "]");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a whacked mole print out a W, or * otherwise.
     */
    void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print("[" + moleGrid[i][j] + "]");
            }
            System.out.println(" ");
        }
    }

    /**\
     * A method to return Attempts Left value.
     * @return remaining attempts
     */
    int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * A method to return moles left value.
     * @return remaining moles
     */
    int getMolesLeft() {
        return  molesLeft;
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
        System.out.println("Enter number of attempts:");
        int numAttempts = readUserInputOnlyIntegers();
        System.out.println("Enter dimension for the grid:");
        int dimensionBegin = readUserInputOnlyIntegers();

        WhackAMole whackAmole = new WhackAMole(numAttempts, dimensionBegin);

        System.out.println("Enter the amount of moles");
        int amountMoles = readUserInputOnlyIntegers();
        whackAmole.placeTheMoles(amountMoles, dimensionBegin);

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
            userInputX = readUserInputForGame();
            System.out.println("Enter Y: ");
            userInputY = readUserInputForGame();

            // Printing the coordinates submitted by the user
            System.out.println("User input: [X=" + userInputX + "][Y=" + userInputY + "]");

            // Conditional if the user wants to finish the game
            if (userInputX == -1 || userInputY == -1) {
                whackAmole.printGrid();
                whackAmole.printStatus();
                System.out.println("GAME OVER: User gave up");
                break;
            }

            // Positioning the user's hit
            whackAmole.whack(userInputX, userInputY);
            whackAmole.printGridToUser();
            whackAmole.printStatus();

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
    public static int readUserInputForGame() {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        String value = " ";
        boolean flag = true;
        while (flag) {
            value = scanner.next();
            if (!value.matches("^((-1)?|^[0-9])$")) {
                flag = false;
            } else {
                System.out.print("Wrong input. Insert again: ");
            }
        }
        return Integer.parseInt(value);
    }

    /**
     * A method to read user input only integers.
     * @return value submitted by the user
     */
    public static int readUserInputOnlyIntegers() {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        String value = " ";

        // The code to avoid Inner assignments should be avoided
        boolean flag = true;
        while (flag) {
            value = scanner.next();
            if (!value.matches("^[0-9]+$")) {
                flag = false;
            } else {
                System.out.print("Wrong input. Insert again: ");
            }
        }

        // The following code fails with error:
        // Inner assignments should be avoided.
//        String value;
//        while (!(value = scanner.next()).matches("^((-1)?|^[0-9])$")) {
//            System.out.print("Wrong input. Insert again: ");
//        }

        return Integer.parseInt(value);
    }
}
