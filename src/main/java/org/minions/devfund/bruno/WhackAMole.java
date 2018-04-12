package org.minions.devfund.bruno;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * This Class.
 */
public class WhackAMole {

    private static final String BLANK_SPACE = " ";
    private Random random;
    private String moleGrid[][];
    private boolean quitGame = false;
    private int score;
    private int molesLeft;
    private int attemptsLeft;

    /**
     * Initializes the constructor for WhackAMole game.
     *
     * @param numAttempts   Integer attempts number.
     * @param gridDimension Integer Dimension grid.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new String[gridDimension][gridDimension];
        random = new Random();
        generateGrid();

    }

    /**
     * Generates the grid initial.
     */
    private void generateGrid() {
        int gridLength = moleGrid.length;
        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridLength; col++) {
                moleGrid[row][col] = "o";
            }
        }
    }

    /**
     * Prints the grid without showing where the moles are.
     */
    public void printGridToUser() {
        int gridLength = moleGrid.length;
        for (String[] row : moleGrid) {
            IntStream.range(0, gridLength).mapToObj(col -> hideMole(row[col]))
                    .forEach(System.out::print);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * @param moleGrid
     * @return
     */
    private String hideMole(String moleGrid) {
        return  BLANK_SPACE.concat(moleGrid).concat(BLANK_SPACE);
    }

    /**
     * It places a mole at that location.
     *
     * @param xMole Integer X coordinate of the mole place.
     * @param yMole Integer Y coordinate of the mole place.
     * @return true if you can place a mole at that location.
     */
    public boolean place(final int xMole, final int yMole) {
        boolean isPlaceMole = !moleGrid[xMole][yMole].equals("M");
        moleGrid[xMole][yMole] = isPlaceMole ? "M" : "o";
        molesLeft += 1;
        return isPlaceMole;
    }

    /**
     * @param numMoles
     */
    public void placeAllMoles(int numMoles) {
        molesLeft = numMoles;
        int gridLength = moleGrid.length;
        int moles = numMoles;
        while (moles > 0) {
            if (place(random.nextInt(gridLength), random.nextInt(gridLength))) {
                moles--;
            }
        }
    }

    /**
     * It makes a whack at that location.
     *
     * @param xWhack Integer X coordinate of the whack place.
     * @param yWhack Integer Y coordinate of the whack place.
     */
    public void whack(final int xWhack, final int yWhack) {
        moleGrid[xWhack][yWhack] = moleGrid[xWhack][yWhack].equals("M") ? "W" : "*";
        if (exitGame(xWhack, yWhack)) {
            quitGame = true;
            System.out.println("Exiting Game!\n");
        } else if (validCordinates(xWhack, yWhack)) {
            checkTheMoleInTheGrid(xWhack, yWhack);
        } else {
            System.out.println("Hmmmm. It seems you put in an invalid entry.");
            System.out.println("Please enter values from 1 to " + moleGrid.length + ".\n");
        }
    }

    /**
     * It checks if the mole is in this coordinates.
     *
     * @param xWhack Integer X coordinate of the whack place.
     * @param yWhack Integer Y coordinate of the whack place.
     */
    private void checkTheMoleInTheGrid(int xWhack, int yWhack) {
        boolean asd = moleGrid[xWhack][yWhack].equals("M");
        String asda = moleGrid[xWhack][yWhack];
        if (moleGrid[xWhack][yWhack].equals("M")) {
            moleGrid[xWhack][yWhack] = "W";
            molesLeft--;
            attemptsLeft--;
            score++;
            System.out.println("You hit a mole!\n");
        } else {
            moleGrid[xWhack][yWhack] = "*";
            attemptsLeft--;
            System.out.println("Oops! No mole there!\n");
        }
    }


    public boolean exitGame(int x, int y) {
        return x == -1 && y == -1;
    }

    public boolean validCordinates(int x, int y) {
        return (x >= 0 && x < moleGrid.length) && (y >= 0 && y < moleGrid.length);
    }

    /**
     * Manages the game states.
     *
     * @return bolean true for finishing and false to continue.
     */
    boolean gameOver() {
        if (quitGame) {
            System.out.println("You have quit the game.");
            System.out.println("Here is how far you got!");
            System.out.println("Thanks for playing");
            return true;
        }
        if (molesLeft == 0) {
            System.out.println("There are no moles left!");
            System.out.println("You won the game!");
            return true;
        } else if (attemptsLeft == 0) {
            System.out.println("You have no tries left!");
            System.out.println("You lost the game!");
            return true;
        } else {
            System.out.println("You actual score ".concat(String.valueOf(score)));
            return false;
        }
    }
}
