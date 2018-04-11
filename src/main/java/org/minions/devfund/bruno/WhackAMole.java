package org.minions.devfund.bruno;

import java.util.Random;

/**
 * This Class.
 */
public class WhackAMole {

    public static final int RANGE = 9;
    private int attemptsNumber;
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private String moleGrid[][];
    Random random;

    /**
     * Initializes the constructor for WhackAMole game.
     *
     * @param numAttempts   Integer attempts number.
     * @param gridDimension Integer Dimension grid.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        attemptsNumber = numAttempts;
        moleGrid = new String[gridDimension][gridDimension];
        random = new Random();

    }

    /**
     * It places a mole at that location.
     *
     * @param xPlaceMole Integer X coordinate of the mole place.
     * @param yPlaceMole Integer Y coordinate of the mole place.
     * @return true if you can place a mole at that location.
     */
    public boolean place(final int xPlaceMole, final int yPlaceMole) {
        moleGrid[xPlaceMole][yPlaceMole] = moleGrid[xPlaceMole][yPlaceMole].equals("M  ") ? "M  " : "o  ";
        return random.nextBoolean();
    }

    /**
     * It makes a whack at that location.
     *
     * @param xWhack Integer X coordinate of the whack place.
     * @param yWhack Integer Y coordinate of the whack place.
     */
    public void whack(final int xWhack, final int yWhack) {

//        boolean attempt = random.nextBoolean();

        moleGrid[xWhack][yWhack] = moleGrid[xWhack][yWhack].equals("M  ") ? "W  " : "*  ";
//        System.out.print(moleGrid[xWhack][yWhack]);
    }

    /**
     * Prints the grid without showing where the moles are.
     */
    public void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] =  "o  ";
                System.out.print(moleGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            moleGrid[random.nextInt(RANGE)][random.nextInt(RANGE)] = "M  ";
        }

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Prints the grid without showing where the moles are.
     */
    public void printGrid() {
            for (int j = 0; j < 50; j++) {
                whack(random.nextInt(RANGE),random.nextInt(RANGE));
            }

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Gets the attempts number.
     *
     * @return Integer attempts number.
     */
    public int getAttemptsNumber() {
        return attemptsNumber;
    }
}
