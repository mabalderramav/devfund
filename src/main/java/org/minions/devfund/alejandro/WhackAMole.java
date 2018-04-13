package org.minions.devfund.alejandro;

/**
 * Class for whack a mole.
 */
public class WhackAMole {

    int score;
    int molesLeft;
    int moles;
    int attemptsLeft;
    final char[][] moleGrid;
    final int size;
    static final char MOLE = 'M';
    static final char NOTHING = '*';

    /**
     * This is the constructor for the whack a mole class.
     * @param numAttempts is the number of attempts the user will have to find the moles.
     * @param gridDimension is the dimension of the grid where the player will play.
     */
    public WhackAMole(int numAttempts, int gridDimension) {

        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.size = gridDimension;
    }

    /**
     * Given a location, place a mole at that location.
     * @param x The position in x where the mole will be tried to be placed.
     * @param y The position in y where the mole will be tried to be placed.
     * @return true or false if the mole can be placed there.
     */
     boolean place(int x, int y) {

        if (this.moleGrid[x][y] == MOLE) {
            return false;
        } else {
            this.moles--;
            this.moleGrid[x][y] = MOLE;
            return true;
        }
    }

    /**
     * Given a location, take a whack at that location.
     * If that location contains a mole, the score,
     * number of attemptsLeft, and molesLeft is updated.
     * If that location does not contain a mole,
     * only attemptsLeft is updated.
     * @param x The position in x where the player will make a whack.
     * @param y The position in y where the player will make a whack.
     */
     void whack(int x, int y) {

        char whack = 'W';
        if (this.moleGrid[x][y] == MOLE) {
            this.moleGrid[x][y] = whack;
            this.score++;
            this.molesLeft--;
            this.attemptsLeft--;
        } else {
            this.attemptsLeft--;
        }
    }

    /**
     * This method will set the amount of moles.
     * @param moles The amount of moles that will be in game.
     */
     void setMoles(int moles) {

        this.moles = moles;
        this.molesLeft = moles;
    }

    /**
     * This method fill the matrix with wildcard "*", "M".
     */
     void fillMatrix() {

        fillGrid();
        fillMoles(size);
    }

    /**
     * This method will fill the matrix with moles.
     * @param size the size of the matrix.
     */
     void fillMoles(int size) {

        java.util.Random ran = new java.util.Random();
        for (int i = 0; i < size; i++) {
            boolean p = false;
            while (!p) {
                int randomX = ran.nextInt(size);
                int randomY = ran.nextInt(size);
                if (place(randomX, randomY)) {
                    p = true;
                }
            }
        }
    }

    /**
     *  This method will fill the matrix with "*".
     */
     void fillGrid() {

        for (int i = 0; i < moleGrid.length; i++) {
            for (int y = 0; y < moleGrid.length; y++) {
                moleGrid[i][y] = NOTHING;
            }
        }
    }

    /**
     * This method display the matrix.
     * @param mode this will determine if the print will be for the user,
     *             or if will display the moles without hidden.
     */
     void grid(char mode) {

        for (char[] aMoleGrid : moleGrid) {
            for (int y = 0; y < moleGrid.length; y++) {
                if (mode == 'u' && (aMoleGrid[y] == MOLE)) {
                    System.out.print(" " + NOTHING + " ");
                } else {
                    System.out.print(" " + aMoleGrid[y] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * This method display the matrix for the user.
     */
     void printGridToUser() {

        char mode = 'u';
        grid(mode);
    }

    /**
     * This method will display the matrix without hide the moles.
     */
     void printGrid() {

        char mode = 'i';
        grid(mode);
    }

    /**
     * This method return the score.
     * @return score: the score the player has.
     */
     int getScore() {

        return this.score;
    }

    /**
     * This method return the moles that are left.
     * @return moleLeft: the moleLeft on the matrix.
     */
     int getMoleLeft() {

        return this.molesLeft;
    }

    /**
     * This method return the attemps left for the player.
     * @return attempsLeft: the attempsLeft the player has.
     */
     int getAttemptsLeft() {

        return this.attemptsLeft;
    }
}
