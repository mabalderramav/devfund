package org.minions.devfund;

/**
 * Class that simulate the Whackamole game
 */
public class WhackAMole {
    public int score;
    public int molesLeft;
    public int attemptsLeft;
    public char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   Specify the max number of attempt to be used in the game.
     * @param gridDimension Define the grid dimension.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
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
     * @return True if the Mole was positioned in a grid, otherwise false.
     */
    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] == '*') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Method that perform a whack in the grid
     *
     * @param x Represents the X axes position in the grid.
     * @param y Represents the Y axes position in the grid.
     */
    public void whack(int x, int y) {
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
    public void printGridToUser() {
        for (char[] row : moleGrid) {
            for (char cell_value : row) {
                if (cell_value == 'M' || cell_value == '*') {
                    System.out.print("*");
                } else {
                    System.out.print("W");
                }
            }
            System.out.println();

        }
    }

    /**
     * Method that print the whole grid in its current state
     */
    public void printGrid() {
        for (char[] row : moleGrid) {
            for (char cell_value : row) {
                System.out.print(cell_value);
            }
            System.out.println();
        }
    }
}
