package org.minions.devfund.lourdes;

/**
 * Class that simulate the Whackamole game.
 */
class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   Specify the max number of attempt to be used in the game.
     * @param gridDimension Define the grid dimension.
     */
    WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * Method to place a Mole into the Grid.
     *
     * @param x Represents the X axes position in the grid.
     * @param y Represents the Y axes position in the grid.
     */
    void place(int x, int y) {
        if (this.moleGrid[x][y] == '*') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
        }
    }

    /**
     * Method that perform a whack in the grid.
     *
     * @param x Represents the X axes position in the grid.
     * @param y Represents the Y axes position in the grid.
     */
    void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            molesLeft--;
            score++;
            moleGrid[x][y] = 'W';
        }
        attemptsLeft--;
    }

    /**
     * Method that print the grid without showing the moles.
     */
    void printGridToUser() {
        for (char[] row : moleGrid) {
            for (char cellValue : row) {
                if (cellValue == 'M' || cellValue == '*') {
                    System.out.print("*");
                } else {
                    System.out.print("W");
                }
            }
            System.out.println();

        }
    }

    /**
     * Method that print the whole grid in its current state.
     */
    void printGrid() {
        for (char[] row : moleGrid) {
            for (char cellValue : row) {
                System.out.print(cellValue);
            }
            System.out.println();
        }
    }

    /**
     * Method that return the score.
     *
     * @return score data.
     */
    public int getScore() {
        return score;
    }

    /**
     * Method tha return the moles left.
     *
     * @return moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Method that return the attempts left.
     *
     * @return attempts left
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
