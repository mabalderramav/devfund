package org.minions.devfund.mauricioz;

/**
 *  Class for Squarelotron homework.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;

    /**
     * constructor.
     * @param n size to initialize the bi-dimensional array and the size.
     */
    public Squarelotron(int n) {
        squarelotron = new int[n][n];
        size = n;
        initializeSquarelotron();
    }

    /**
     * flip a given ring of the squarelotron.
     * @param ring number of ring that will be flipped
     * @return new squarelotron flipped
     */
    public Squarelotron upsideDownFlip(int ring) {
        //TODO
        return this;
    }

    /**
     * testing.
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * just for testing purposes.
     */
    private void initializeSquarelotron() {
        int count = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = count;
                count++;
            }
        }
    }

    /**
     * just for testing purposes.
     */
    private void printIt() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(squarelotron[i][j]);
            }
            System.out.println('\n');
        }
    }

}
