package org.minions.devfund.alejandro;

/**
 * Squareotron class
 */
public class Squarelotron {

    public int[][] squarelotron;
    int size;

    /**
     * It fills the 2-dimensional array with the numbers 1 to n squared, in order.
     * It also sets the size instance variable to be n.
     * @param n The size for the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        n = 1;
        squarelotron = new int[this.size][this.size];
        for (int x = 0; x < this.size; x++){
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
        Squarelotron innerSquare = new Squarelotron(this.size);
        Squarelotron resSquare = new Squarelotron(this.size);

        int controlSize = ring - 1;
        int[] row;
        int[] row1;

        for(int i = this.size - ring; i < ring/2; i++) {
            row = swapSquare.squarelotron[i];
            row1 = swapSquare.squarelotron[controlSize];
            swapSquare.squarelotron[i] = row1;
            swapSquare.squarelotron[controlSize] = row;
            controlSize--;
        }

        for(int i = this.size - ring; i < ring; i++){
            for(int j = this.size - ring; j < ring; j++){
                innerSquare.squarelotron[i][j] = swapSquare.squarelotron[i][j];
            }
        }

        for(int i = this.size - ring; i < ring/2; i++){
            for(int j = this.size - ring; j < ring; j++){
                if(i == 0 || j == 0 || i == ring - 1 || j == ring - 1) {
                    innerSquare.squarelotron[i][j] = resSquare.squarelotron[i][j];
                }
            }
        }


        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if(i == 0 || j == 0 || i == ring - 1 || j == ring - 1) {
                    resSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }else {
                    resSquare.squarelotron[i][j] = innerSquare.squarelotron[i][j];
                }
            }
        }

        for(int i = 0; i < innerSquare.squarelotron.length; i++){
            for(int j = 0 ; j < innerSquare.squarelotron.length; j++){
                System.out.print(resSquare.squarelotron[i][j] + " ");
            }
            System.out.println();
        }

        return resSquare;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron, as described above,
     * and returns the new squarelotron. The original squarelotron should not be modified (we will check for this).
     * @param ring
     * @return
     */
//    Squarelotron mainDiagonalFlip(int ring) {
//
//    }


    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the squarelotron; it does not create a new squarelotron.
     * @param numberOfTurns
     */
    void rotateRight(int numberOfTurns) {

    }
}
