package org.minions.devfund.marylin;

public class Squarelotron {
    int[][] squarelotron;
    int size;
    int numberOfRings;

    /**
     * Constructor of the matrix n x n initialized with consecutive values from 1 to m
     *
     * @param n size of the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[n][n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = number;
                number++;
            }
        }
    }

    /**
     * Constructs an Squarelotron from an array of array
     *
     * @param squarelotron instance of an Squarelotron
     */
    public Squarelotron(int[][] squarelotron) {
        this.size = squarelotron.length;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.squarelotron[i][j] = squarelotron[i][j];
                this.squarelotron[i][j] = squarelotron[i][j];
            }
        }
    }

    /**
     * Compare two Squarelotron
     *
     * @param object Squarelotron instance
     * @return Squarelotron instance
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Squarelotron)) {
            return false;
        }

        Squarelotron squarelotronTemp = (Squarelotron) object;
        for (int i = 0; i < this.squarelotron.length; i++) {
            for (int j = 0; j < this.squarelotron.length; j++) {
                if (this.squarelotron[i][j] != squarelotronTemp.squarelotron[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Duplicates an array of arrays
     *
     * @param original array of array
     * @return the duplicated array
     */
    private int[][] duplicateGrid(int[][] original) {
        int size = original.length;
        int[][] backupGrid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                backupGrid[i][j] = original[i][j];
            }
        }
        return backupGrid;
    }

    /**
     * Prints the Squarelotron
     */
    void printSquarelotron() {
        for (int i = 0; i < squarelotron.length; i++) {
            for (int j = 0; j < squarelotron.length; j++) {
                System.out.print(" " + squarelotron[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Upside Down Flip
     *
     * @param ring number
     * @return an instance of Squarelotron
     */
    Squarelotron upsideDownFlip(int ring) {
        int[][] resultGrid = duplicateGrid(this.squarelotron);

        //Returns the same squarelotron if the ring number is equal to the number of rings of a matrix n x n
        if (this.size % 2 == 1 && ring == this.numberOfRings) {
            return this;
        }

        //
        if (ring != 1) {
            int temp = 1;
            for (int i = this.size - 2; i >= this.size / 2; i--) {
                for (int j = 1; j < this.size - 1; j++) {
                    resultGrid[i][j] = this.squarelotron[temp][j];
                    resultGrid[temp][j] = this.squarelotron[i][j];
                }
                temp++;
            }
        } else { //
            int temp = 0;
            for (int i = this.size - 1; i >= this.size / 2; i--) {
                for (int j = 0; j < this.size; j++) {
                    resultGrid[i][j] = this.squarelotron[temp][j];
                    resultGrid[temp][j] = this.squarelotron[i][j];
                }
                temp++;
            }

            // Restore values of the internal rings if there are
            for (int i = 1; i < this.size - 1; i++) {
                for (int j = 1; j < this.size - 1; j++) {
                    resultGrid[i][j] = this.squarelotron[i][j];
                }
            }
        }
        return new Squarelotron(resultGrid);
    }

    Squarelotron mainDiagonalFlip(int ring) {
        int[][] resultGrid = duplicateGrid(this.squarelotron);

        if (this.size % 2 == 1 && ring == this.numberOfRings) {
            return this; // returns the same squarelotron if the ring number is equal to the number of rings
        }
        if (ring != 1) {
            int temp_j = 1;
            for (int i = 1; i < this.size - 1; i++) {
                resultGrid[i][temp_j] = this.squarelotron[temp_j][i];
                resultGrid[temp_j][i] = this.squarelotron[i][temp_j];
            }

            int temp_i = this.size - 2;
            for (int j = 1; j < this.size - 2; j++) {
                resultGrid[temp_i][j] = this.squarelotron[j][temp_i];
                resultGrid[j][temp_i] = this.squarelotron[temp_i][j];
            }
        } else {
            int temp_j = 0;
            for (int i = 1; i < this.size; i++) {
                resultGrid[i][temp_j] = this.squarelotron[temp_j][i];
                resultGrid[temp_j][i] = this.squarelotron[i][temp_j];
            }

            int temp_i = this.size - 1;
            for (int j = 1; j < this.size - 1; j++) {
                resultGrid[temp_i][j] = this.squarelotron[j][temp_i];
                resultGrid[j][temp_i] = this.squarelotron[temp_i][j];
            }
        }
        return new Squarelotron(resultGrid);
    }

    int[][] completeUpsideDownFlip() {
        int[][] resultGrid = duplicateGrid(this.squarelotron);
        int temp = 0;
        for (int i = this.size - 1; i >= this.size / 2; i--) {
            for (int j = 0; j < this.size; j++) {
                resultGrid[i][j] = this.squarelotron[temp][j];
                resultGrid[temp][j] = this.squarelotron[i][j];
            }
            temp++;
        }
        return resultGrid;
    }

    Squarelotron rotateRight(int numberOfTurns) {
        int[][] resultGrid = completeUpsideDownFlip();
        Squarelotron squarelotron = null;
        while (numberOfTurns > 0) {
            squarelotron = new Squarelotron(resultGrid);
            for (int i = 0; i <= numberOfTurns; i++) {
                squarelotron = squarelotron.mainDiagonalFlip(i + 1);
            }
            resultGrid = squarelotron.squarelotron;
            numberOfTurns--;
        }
        return squarelotron;
    }
}
