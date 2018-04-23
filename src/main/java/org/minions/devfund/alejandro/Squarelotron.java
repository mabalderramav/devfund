package org.minions.devfund.alejandro;

/**
 * Squareotron class.
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int size;

    /**
     * It fills the 2-dimensional array with the numbers 1 to n squared, in order.
     * It also sets the size instance variable to be n.
     * @param n The size for the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        n = 1;
        squarelotron = new int[this.size][this.size];
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                squarelotron[x][y] = n++;
            }
        }
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotron,
     * and returns the new squarelotron. The original squarelotron should not be modified (we will check for this).
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron upsideDownFlip(int ring) {

        Squarelotron swapSquare = new Squarelotron(this.size);
        Squarelotron resultSquare = new Squarelotron(this.size);

        swapSquare.squarelotron = this.getSquarelotron();
        if (ring > 0 && ring <= this.size / 2) {
            int controlSize = this.size - 1;
            int[] row;
            int[] row1;

            for (int i = 0; i < this.size / 2; i++) {
                row = swapSquare.squarelotron[i];
                row1 = swapSquare.squarelotron[controlSize];
                swapSquare.squarelotron[i] = row1;
                swapSquare.squarelotron[controlSize] = row;
                controlSize--;
            }

            for (int i = ring - 1; i <= this.size - ring; i++) {
                for (int j = ring - 1; j <= this.size - ring; j++) {
                    if (i == ring - 1 || j == ring - 1 || i == this.size - ring || j == this.size - ring) {
                        resultSquare.squarelotron[i][j] = swapSquare.squarelotron[i][j];
                    }
                }
            }
        }
        return resultSquare;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron,
     * and returns the new squarelotron. The original squarelotron should not be modified (we will check for this).
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron resultSquare = new Squarelotron(this.size);

        if (ring > 0 && ring <= this.size / 2) {
            for (int i = ring - 1; i <= this.size - 1; i++) {
                for (int j = ring - 1; j <= this.size - 1; j++) {
                    if (i == ring - 1 || j == ring - 1 || i == this.size - ring || j == this.size - ring) {
                        resultSquare.squarelotron[i][j] = this.squarelotron[j][i];
                    }
                }
            }
        }
        return resultSquare;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the squarelotron; it does not create a new squarelotron.
     * @param numberOfTurns the amount of times that will be rotated.
     */
    public void rotateRight(int numberOfTurns) {

        if (numberOfTurns >= 0) {
            rotateClockWise(numberOfTurns);
        } else {
            rotateCounterClockWise(numberOfTurns);
        }
    }

    /**
     * This method will rotate the matrix to the right.
     * @param numberOfTurns the amount of times that will be rotated.
     */
    private void rotateClockWise(int numberOfTurns) {

        Squarelotron tempSquare = new Squarelotron(this.size);

        while (numberOfTurns > 0) {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    this.squarelotron[j][this.size - 1 - i] = tempSquare.squarelotron[i][j];
                }
            }
            for (int i = 0; i < this.size; i++) {
                System.arraycopy(this.squarelotron[i], 0, tempSquare.squarelotron[i], 0, this.size);
            }
            numberOfTurns--;
        }
    }

    /**
     * This method will rotate the matrix to the left.
     * @param numberOfTurns the amount of times that will be rotated.
     */
    private void rotateCounterClockWise(int numberOfTurns) {

        Squarelotron tempSquare = new Squarelotron(this.size);

        while (numberOfTurns < 0) {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    this.squarelotron[this.size - 1 - j][i] = tempSquare.squarelotron[i][j];
                }
            }
            for (int i = 0; i < this.size; i++) {
                System.arraycopy(this.squarelotron[i], 0, tempSquare.squarelotron[i], 0, this.size);
            }
            numberOfTurns++;
        }
    }

    /**
     * This method return the squarelotron matrix.
     * @return a bi dimensional array.
     */
    public int[][] getSquarelotron() {
        int[][] squareToReturn = this.squarelotron;
        return squareToReturn;
    }
}
