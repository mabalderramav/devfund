package org.minions.devfund.marylin;

public class Squarelotron {
    int[][] squarelotron;
    int size;
    int numberOfRings;

    /**
     * @param n
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
                //System.out.print(this.squarelotron[i][j]+" ");
            }
            //System.out.println();
        }
        return true;
    }

    Squarelotron upsideDownFlip(int ring) {
        int[][] resultGrid = duplicateGrid(this.squarelotron);

        if (this.size % 2 == 1 && ring == this.numberOfRings) {
            return this; // returns the same squarelotron if the ring number is equal to the number of rings
        }

        if (ring != 1) {
            int temp = 1;
            for (int i = this.size - 2; i >= this.size / 2; i--) {
                for (int j = 1; j < this.size - 1; j++) {
                    System.out.print("* ");
                    System.out.print(resultGrid[i][j] + "(" + i + "," + j + ") - ");
                    System.out.print(this.squarelotron[temp][j] + "(" + (temp) + "," + j + ") - ");
                    resultGrid[i][j] = this.squarelotron[temp][j];
                    resultGrid[temp][j] = this.squarelotron[i][j];
                }
                temp++;
                System.out.println();
            }
        } else {
            int temp = 0;
            for (int i = this.size - 1; i >= this.size / 2; i--) {
                for (int j = 0; j < this.size; j++) {
                    System.out.print("* ");
                    System.out.print(resultGrid[i][j] + "(" + i + "," + j + ") - ");
                    System.out.print(this.squarelotron[temp][j] + "(" + (temp) + "," + j + ") - ");
                    resultGrid[i][j] = this.squarelotron[temp][j];
                    resultGrid[temp][j] = this.squarelotron[i][j];
                }
                temp++;
                System.out.println();
            }

            for (int i = 1; i < this.size - 1; i++) {
                for (int j = 1; j < this.size - 1; j++) {
                    resultGrid[i][j] = this.squarelotron[i][j];
                }
                System.out.println();
            }
        }
        return new Squarelotron(resultGrid);
    }

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

    Squarelotron mainDiagonalFlip(int ring) {
        return null;
    }

    void rotateRight(int numberOfTurns) {

    }

    void printSquarelotron() {
        for (int i = 0; i < squarelotron.length; i++) {
            for (int j = 0; j < squarelotron.length; j++) {
                System.out.print(" " + squarelotron[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Squarelotron squarelotron = new Squarelotron(5);
        squarelotron.printSquarelotron();

        Squarelotron squarelotron2 = squarelotron.upsideDownFlip(1);
        System.out.println("----------------------------");
        squarelotron2.printSquarelotron();
        System.out.println("----------------------------");
        squarelotron.printSquarelotron();

    }
}
