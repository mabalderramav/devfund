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
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.size = gridDimension;
    }

    private boolean place(int x, int y) {
        if (this.moleGrid[x][y] == mole) {
            return false;
        } else {
            this.moles--;
            this.moleGrid[x][y] = mole;
            return true;
        }
    }

    public void whack(int x, int y) {
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
        this.moles = moles;
        this.molesLeft = moles;
    }

    public void fillMatrix() {
        fillGrid();
        fillMoles(size);
    }

    private void fillMoles(int size) {
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
        for (int i = 0; i < moleGrid.length; i++) {
            for (int y = 0; y < moleGrid.length; y++) {
                moleGrid[i][y] = nothing;
            }
        }
    }

    private void grid(char mode) {

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
        char mode = 'u';
        grid(mode);
    }

    public void printGrid() {
        char mode = 'i';
        grid(mode);
    }

    public int getScore() {
        return this.score;
    }

    public int getMoleLeft() {
        return this.molesLeft;
    }

    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}
