package org.minions.devfund.jhasmany;

/**
 * Class that handle all related to Whack a mole.
 *
 * @author Jhasmany Quiroz
 */
public class WhackAMole {

    private int scores;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Method constructor.
     *
     * @param numAttempts
     *            is the number of attempts.
     * @param gridDimension
     *            is the size of the Grid.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
	this.attemptsLeft = numAttempts;
	this.moleGrid = new char[gridDimension][gridDimension];
	this.scores = 0;
	this.molesLeft = 0;
	fillMoleGrid();
    }

    /**
     * Place the Mole 'M' in the coordinates specified.
     *
     * @param x
     *            is the coordinate X.
     * @param y
     *            is the coordinate Y.
     * @return true if the mole doesn't exist, otherwise false.
     */
    public boolean place(int x, int y) {
	if (this.moleGrid[x][y] != 'M') {
	    this.moleGrid[x][y] = 'M';
	    this.molesLeft++;
	    return true;
	}

	return false;
    }

    /**
     * Put the whack in the coordinates passed as parameter.
     *
     * @param x
     *            is coordinate x.
     * @param y
     *            is coordinate y.
     */
    public void whack(int x, int y) {
	if (x < this.moleGrid.length && y < this.moleGrid.length) {
	    if (this.moleGrid[x][y] == 'M') {
		this.moleGrid[x][y] = 'W';
		this.scores++;
		this.attemptsLeft--;
		this.molesLeft--;
	    } else {
		this.moleGrid[x][y] = '*';
		this.attemptsLeft--;
	    }
	} else {
	    System.out.println("The coordinates aren't exist");
	    this.attemptsLeft = 0;
	}
    }

    /**
     * Print all grid without 'M'.
     */
    public void printGridToUser() {
	for (int i = 0; i < this.moleGrid.length; i++) {
	    for (int j = 0; j < this.moleGrid[i].length; j++) {
		if (this.moleGrid[i][j] != 'M') {
		    System.out.print("[ " + this.moleGrid[i][j] + " ]");
		} else {
		    System.out.print("[ * ]");
		}
	    }

	    System.out.println();
	}
    }

    /**
     * Method that returns the 'scores' attribute.
     *
     * @return a integer.
     */
    public int getScores() {
	return scores;
    }

    /**
     * Method that returns the 'molesLeft' attribute.
     *
     * @return a integer.
     */
    public int getMolesLeft() {
	return molesLeft;
    }

    /**
     * Method that returns the 'attemptsLeft' attribute.
     *
     * @return a integer.
     */
    public int getAttemptsLeft() {
	return attemptsLeft;
    }

    /**
     * Method that returns the 'moleGrid' attribute.
     *
     * @return a character matrix.
     */
    public char[][] getMoleGrid() {
	return moleGrid;
    }

    /**
     * Print all grid.
     */
    public void printGrid() {
	for (int i = 0; i < this.moleGrid.length; i++) {
	    for (int j = 0; j < this.moleGrid[i].length; j++) {
		System.out.print("[ " + this.moleGrid[i][j] + " ]");
	    }

	    System.out.println();
	}
    }

    /**
     * Put the mole randomly.
     *
     * @param quantity
     *            indicate the mole's number.
     */
    public void putTheMoles(int quantity) {
	int x, y, counter;
	counter = 0;

	while (counter < quantity) {
	    x = (int) (Math.random() * (this.moleGrid.length - 1) + 1);
	    y = (int) (Math.random() * (this.moleGrid.length - 1) + 1);

	    if (place(x, y)) {
		counter++;
	    }
	}
    }

    /**
     * Fill the grid with '*'.
     */
    public void fillMoleGrid() {
	for (int i = 0; i < this.moleGrid.length; i++) {
	    for (int j = 0; j < this.moleGrid[i].length; j++) {
		this.moleGrid[i][j] = '*';
	    }
	}
    }
}
