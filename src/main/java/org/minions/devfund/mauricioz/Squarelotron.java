package org.minions.devfund.mauricioz;
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
        initializeSquarelotron(n);
    }

    /**
     * Populate squarelotron with initial values.
     * @param n size of the squarelotron
     */
    private void initializeSquarelotron(int n) {
        for (int x = 0; x < getSize(); x++) {
            for (int y = 0; y < getSize(); y++) {
                squarelotron[x][y] = n++;
            }
        }
    }

    /**
     * This method return the squarelotron size.
     * @return squarelotron size
     */
    private int getSize() {
        return size;
    }

    /**
     * Upside-Down Flip of the squarelotron,
     * and returns the new squarelotron. The original squarelotron should not be modified.
     * @param ring the ring that will be flipped.
     * @return A upside-down flipped squrelotron on a new instance.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron flippedSquarelotron = new Squarelotron(getSize());
        if (ring > 0 && ring <= this.getSize() / 2) {
            flippedSquarelotron.squarelotron = flipSquarelotron(ring, flippedSquarelotron.getSquarelotron());
        }
        return flippedSquarelotron;
    }

    /**
     * This method perform a flip of the 2D array for a given ring.
     * @param ring the ring that will be flipped in the square.
     * @param flippedSquarelotron 2D array that will be flipped.
     * @return the flipped 2D array.
     */
    private int[][] flipSquarelotron(int ring, final int[][] flippedSquarelotron) {
        int[][] swappedMatrix = inverseMatrix(this.squarelotron);
        for (int i = ring - 1; i <= this.getSize() - ring; i++) {
            for (int j = ring - 1; j <= this.getSize() - ring; j++) {
                if (isPositionInRing(ring, i, j)) {
                    flippedSquarelotron[i][j] = swappedMatrix[i][j];
                }
            }
        }
        return flippedSquarelotron;
    }

    /**
     * This method will invert the 2D array.
     * @param matrix 2D that will be inverted.
     * @return the 2D array but inverted.
     */
    private int[][] inverseMatrix(final int[][] matrix) {
        int controlSize = this.getSize() - 1;
        for (int i = 0; i < this.getSize() / 2; i++) {
            int[] rowUpside = matrix[i];
            int[] rowDown = matrix[controlSize];
            matrix[i] = rowDown;
            matrix[controlSize] = rowUpside;
            controlSize--;
        }
        return matrix;
    }

    /**
     * This method will verify that given value on given position doesn't belong to the ring.
     * @param ring the ring we are looking in the matrix.
     * @param x position x in the matrix.
     * @param y position y in the matrix.
     * @return true if the position belong to the ring and false otherwise.
     */
    private boolean isPositionInRing(int ring, int x, int y) {
        return x == ring - 1 || y == ring - 1 || x == this.getSize() - ring || y == this.getSize() - ring;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron into a new instance of Squarelotron.
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron squarelotronResultant = new Squarelotron(this.getSize());

        if (ring > 0 && ring <= this.getSize() / 2) {
            for (int i = ring - 1; i <= this.getSize() - ring; i++) {
                for (int j = ring - 1; j <= this.getSize() - ring; j++) {
                    if (isPositionInRing(ring, i, j)) {
                        squarelotronResultant.squarelotron[i][j] = this.squarelotron[j][i];
                    }
                }
            }
        }
        return squarelotronResultant;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90°
     * clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the squarelotron; it does not create a new
     * squarelotron.
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
     * @param numberOfTurns the amount of times that will be rotated to the right.
     */
    private void rotateClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns > 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.squarelotron[i][j];

                    this.squarelotron[i][j] = this.squarelotron[length - j][i];
                    this.squarelotron[length - j][i] = this.squarelotron[length - i][length - j];
                    this.squarelotron[length - i][length - j] = this.squarelotron[j][length - i];
                    this.squarelotron[j][length - i] = temp;
                }
            }
            numberOfTurns--;
        }
    }

    /**
     * This method will rotate the squarelotron to the left.
     * @param numberOfTurns the amount of times that squarelotron will be rotated to the left.
     */
    private void rotateCounterClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns < 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.squarelotron[i][j];

                    this.squarelotron[i][j] = this.squarelotron[j][length - i];
                    this.squarelotron[j][length - i] = this.squarelotron[length - i][length - j];
                    this.squarelotron[length - i][length - j] = this.squarelotron[length - j][i];
                    this.squarelotron[length - j][i] = temp;
                }
            }
            numberOfTurns++;
        }
    }

    /**
     * This method return the squarelotron matrix.
     * @return a bi dimensional array.
     */
    public int[][] getSquarelotron() {
        return this.squarelotron.clone();
    }
}
