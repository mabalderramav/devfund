package org.minions.devfund.mauricioz;

/**
 * class in charge to provide game functionality.
 */
public class WhackAMole {
    private static final int MOLES_LEFT = 10;
    private int score = 0;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * constructor.
     * @param numAttempts number of attempts for the game.
     * @param gridDimension grid size.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        this.molesLeft = MOLES_LEFT;
        initializeMoleGrid();
        placeMolesInTheGrid();
    }

    /**
     * method to verify if whack was over a mole or not.
     * @param x coordinate in x.
     * @param y coordinate in y.
     * @return true if mole was whacked.
     */
    public boolean place(int x, int y) {
        return moleGrid[x][y] == 'M';
    }

    /**
     * Whack over a mole.
     * @param x coordinate in x.
     * @param y coordinate in y.
     */
    public void whack(int x, int y) {
        if (place(x, y)) {
            moleGrid[x][y] = 'W';
            molesLeft--;
            score += 1;
        }
        attemptsLeft--;
    }

    /**
     *
     * @return attempts left.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     *
     * @return score.
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return moles left.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     *
     * @return size of the grid
     */
    public int getMoleGridLength() {
        return moleGrid.length;
    }

    /**
     *
     * @param x coordinate in x
     * @param y coordinate in y
     * @return value in given position
     */
    public char getMoleGrid(int x, int y) {
        return moleGrid[x][y];
    }

    /**
     * fill the initial grid.
     */
    private void initializeMoleGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * adding moles to the initial grid.
     */
    private void placeMolesInTheGrid() {
        int xCoordinate;
        int yCoordinate;
        for (int i = 0; i < molesLeft; i++) {
            xCoordinate = generateRandomPosition();
            yCoordinate = generateRandomPosition();
            moleGrid[xCoordinate][yCoordinate] = 'M';
        }
    }

    /**
     *
     * @return provide a integer position between 0-9.
     */
    private int generateRandomPosition() {
        final int rndRange = 10;
        double value = Math.random() * rndRange;
        return (int) value;
    }
}
