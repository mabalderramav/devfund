package org.minions.devfund.lourdes;

import java.util.Arrays;

public class Squarelotron {
    int size;
    int[][] squarelotron;

    public Squarelotron(int n) {
        this.size = n;
        squarelotron = new int[n][n];
        int num = 1;
        for (int i = 0; i < squarelotron.length; i++) {
            for (int j = 0; j < squarelotron[i].length; j++) {
                squarelotron[i][j] = num++;
            }
        }
    }

    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron resultSquarelotron = new Squarelotron(size);
        upsideDownFlipHelper(resultSquarelotron, ring);
        return resultSquarelotron;
    }

    public void upsideDownFlipHelper(Squarelotron newSquarelotron, int ring){
        int ringPointer = ring - 1;
        int lastColumnPosition = size - 1 - (ring - 1);
        int lastRowPosition = size - 1 - (ring - 1);
        for (int i = ringPointer; i < size / 2; i++) {
            if (ringPointer == i) {
                newSquarelotron = swapCompleteRows(newSquarelotron, i, lastColumnPosition, ringPointer);
            } else {
                newSquarelotron = swapRingColumns(newSquarelotron, i, ringPointer, lastRowPosition, lastColumnPosition);

            }
            lastRowPosition--;
        }
    }


    private Squarelotron swapRingColumns(Squarelotron resultSquarelotron, int rowPosition, int ringPointer, int lastRowPosition, int lastColumnPosition) {
        int copyOfArrayValue = resultSquarelotron.squarelotron[rowPosition][ringPointer];
        resultSquarelotron.squarelotron[rowPosition][ringPointer] = resultSquarelotron.squarelotron[lastRowPosition][ringPointer];
        resultSquarelotron.squarelotron[lastRowPosition][ringPointer] = copyOfArrayValue;

        copyOfArrayValue = resultSquarelotron.squarelotron[rowPosition][lastColumnPosition];
        resultSquarelotron.squarelotron[rowPosition][lastColumnPosition] = resultSquarelotron.squarelotron[lastRowPosition][lastColumnPosition];
        resultSquarelotron.squarelotron[lastRowPosition][lastColumnPosition] = copyOfArrayValue;
        return resultSquarelotron;
    }

    public Squarelotron swapCompleteRows(Squarelotron resultSquarelotron, int i, int lastColumnPosition, int ringPointer) {
        int[] targetSuperior = resultSquarelotron.squarelotron[i];
        int[] sourceSuperior = Arrays.copyOfRange(targetSuperior, i, lastColumnPosition + 1);
        int[] targetInferior = resultSquarelotron.squarelotron[lastColumnPosition];
        int[] sourceInferior = Arrays.copyOfRange(targetInferior, i, lastColumnPosition + 1);
        System.arraycopy(sourceInferior, 0, targetSuperior, ringPointer, sourceInferior.length);
        System.arraycopy(sourceSuperior, 0, targetInferior, ringPointer, sourceSuperior.length);

        return resultSquarelotron;
    }

    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron resultSquarelotron = new Squarelotron(size);
        mainDiagonalFlipHelper(resultSquarelotron, ring);
        return resultSquarelotron;
    }
    public void mainDiagonalFlipHelper(Squarelotron resultSquarelotron, int ring){
        int startX = ring - 1;
        int sizeMatrix = resultSquarelotron.size - ring;
        int pivote = 0;
        for (int i = startX; i < sizeMatrix; i++) {
            for (int j = ring; j <= sizeMatrix; j++) {
                pivote = resultSquarelotron.squarelotron[i][j];
                resultSquarelotron.squarelotron[i][j] = resultSquarelotron.squarelotron[j][i];
                resultSquarelotron.squarelotron[j][i] = pivote;
            }
        }
        squarelotron = resultSquarelotron.squarelotron;
    }

    public void rotateRight(int numberOfTurns) {
        int numberOfTurnsAbs = Math.abs(numberOfTurns);
        while (numberOfTurnsAbs % 4 > 0) {
            for (int i = 0; i < squarelotron.length; i++) {
                if (numberOfTurns > 0) {
                    upsideDownFlipHelper(this, i + 1);
                    mainDiagonalFlipHelper(this, i + 1);
                } else {
                    mainDiagonalFlipHelper(this, i + 1);
                    upsideDownFlipHelper(this, i + 1);
                }
            }
            numberOfTurnsAbs--;
        }
    }

}
