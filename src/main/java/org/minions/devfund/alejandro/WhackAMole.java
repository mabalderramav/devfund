package org.minions.devfund.alejandro;

public class WhackAMole {
    /**
     * Whack a mole class.
     */
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private int moles;
    private char[][] moleGrid;
    private int size;
    private final char mole = 'M';
    private final char nothing = '*';

    public WhackAMole(int numAttempts, int gridDimension) {
        /**
         * This is the constructor for the whack a mole class
         */
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.size = gridDimension;
    }

    private boolean place(int x, int y) {
        /**
         *  Given a location, place a mole at that location.
         *  Return true if you can. (Also update number of moles left.)
         */
        if (this.moleGrid[x][y] == mole) {
            return false;
        } else {
            this.moles--;
            this.moleGrid[x][y] = mole;
            return true;
        }
    }

    public void whack(int x, int y) {
        /**
         *  Given a location, take a whack at that location.
         *  If that location contains a mole, the score,
         *  number of attemptsLeft, and molesLeft is updated.
         *  If that location does not contain a mole,
         *  only attemptsLeft is updated.
         */
        char whack = 'W';
        if (this.moleGrid[x][y] == mole) {
            this.moleGrid[x][y] = whack;
            this.score++;
            this.molesLeft--;
            this.attemptsLeft--;
        } else {
            this.attemptsLeft--;
        }
    }

    public void setMoles(int moles) {
        /**
         * This method will set the amount of moles
         */
        this.moles = moles;
        this.molesLeft = moles;
    }

    public void fillMatrix() {
        /**
         * This method fill the matrix with wildcard "*", "M"
         */
        fillGrid();
        fillMoles(size);
    }

    private void fillMoles(int size) {
        /**
         * This method will fill the matrix with moles.
         */
        for (int i = 0; i < size; i++) {
            boolean p = false;
            while (!p) {
                int randomX = (int) (Math.random() * size + 0);
                int randomY = (int) (Math.random() * size + 0);
                if (place(randomX, randomY)) {
                    p = true;
                }
            }
        }
    }

    private void fillGrid() {
        /**
         * This method will fill the matrix with "*".
         */
        for (int i = 0; i < moleGrid.length; i++) {
            for (int y = 0; y < moleGrid.length; y++) {
                moleGrid[i][y] = nothing;
            }
        }
    }

    private void grid(char mode) {
        /**
         * This method display the matrix.
         */

        for (char[] aMoleGrid : moleGrid) {
            for (int y = 0; y < moleGrid.length; y++) {
                if (mode == 'u' && (aMoleGrid[y] == mole)) {
                    System.out.print(" " + nothing + " ");
                } else {
                    System.out.print(" " + aMoleGrid[y] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printGridToUser() {
        /**
         * This method display the matrix for the user.
         */
        char mode = 'u';
        grid(mode);
    }

    public void printGrid() {
        /**
         * This method will display the matrix without hide the moles.
         */
        char mode = 'i';
        grid(mode);
    }

    public int getScore() {
        /**
         * This method return the score
         * @return score: the score the player has.
         */
        return this.score;
    }

    public int getMoleLeft() {
        /**
         * This method return the moles that are left
         * @return moleLeft: the moleLeft on the matrix.
         */
        return this.molesLeft;
    }

    public int getAttemptsLeft() {
        /**
         * This method return the attemps left for the player
         * @return attempsLeft: the attempsLeft the player has.
         */
        return this.attemptsLeft;
    }
}
