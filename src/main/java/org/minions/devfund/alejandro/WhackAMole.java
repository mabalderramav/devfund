package org.minions.devfund.alejandro;

/**
 * Class for whack a mole.
 * It contains three integer instance variables called score, molesLeft, and attemptsLeft.
 * Make one more instance variable called moleGrid which is a 2-dimensional array of chars.
 */
public class WhackAMole {

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private StringBuilder auxialiryBuilder = new StringBuilder();


    /**
     * Constructor for the game, specifies total number of whacks allowed,
     * and the grid dimension. After reading through the assignment,
     * make sure to initialize the moleGrid with the appropriate character.
     *
     * @param numAttempts   number of attempts.
     * @param gridDimension grid dimensions.
     */
    WhackAMole(int numAttempts, int gridDimension) {

        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < moleGrid.length; i++) {
            for (int y = 0; y < moleGrid.length; y++) {
                moleGrid[i][y] = '*';
            }
        }
    }

    /**
     * Given a location, place a mole at that location.
     *
     * @param x location.
     * @param y location.
     * @return true if you can. (Also update number of moles left.)
     */
    boolean place(int x, int y) {

        if (this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Given a location, take a whack at that location.
     * If that location contains a mole, the score, number of attemptsLeft,
     * and molesLeft is updated. If that location does not contain a mole, only attemptsLeft is updated.
     *
     * @param x location.
     * @param y location.
     */
    void whack(int x, int y) {

        if (this.moleGrid[x][y] == 'M') {
            this.score++;
            this.attemptsLeft--;
            molesLeft--;
        } else {
            this.attemptsLeft--;
        }
    }

    /**
     * Print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     */
    void printGridToUser() {

        this.auxialiryBuilder.setLength(0);
        for (char[] aMoleGrid : this.moleGrid) {
            for (char[] aMoleGrid1 : this.moleGrid) {
                this.auxialiryBuilder.append('*');
            }
            this.auxialiryBuilder.append("\n");
        }
        System.out.println(this.auxialiryBuilder);
    }

    /**
     * Print the grid completely. This is effectively dumping the 2d array on the screen.
     * The places where the moles are should be printed as an ‘M’.
     * The places where the moles have been whacked should be printed as a ‘W’.
     * The places that don’t have a mole should be printed as *.
     */
    void printGrid() {

        this.auxialiryBuilder.setLength(0);
        for (char[] aMoleGrid : this.moleGrid) {
            for (int y = 0; y < this.moleGrid.length; y++) {
                auxialiryBuilder.append(aMoleGrid[y]);
            }
            this.auxialiryBuilder.append("\n");
        }
        System.out.println(this.auxialiryBuilder);
    }

    /**
     * This method return the score.
     * @return an int.
     */
    int getScore() {
        return this.score;
    }

    /**
     * This method return the moles left.
     * @return an int.
     */
    int getMolesLeft() {
        return this.molesLeft;
    }

    /**
     * This method return the attempts that are left.
     * @return an int.
     */
    int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}

