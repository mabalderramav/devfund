package org.minions.devfund.alejandro.tests;

import org.junit.Test;
import org.minions.devfund.alejandro.Squarelotron;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;

import java.util.Arrays;

/**
 * Class that will test the class Squarelotron
 */
public class SquarelotronTest {

    int[][] expected;
    private final int size = 5;
    private Squarelotron squarelotron;
    private Squarelotron actualSquarelotron;



    /**
     * This method will initialize the Squarelotron class.
     */
    @Before
    public void setUp() {
        squarelotron =  new Squarelotron(size);
    }


    /**
     * This method will test the constructor of the Squareletron.
     */
    @Test
    public void testSquarelotronConstructor() {

        assertThat(squarelotron, instanceOf(Squarelotron.class));

    }


    /**
     * This method will test the flip using the first ring.
     */
    @Test
    public void testUpSideDownFlipFirstRing() {
        int[][] expected = {{21,22,23,24,25},{16,7,8,9,20},{11,12,13,14,15},{6,17,18,19,10},{1,2,3,4,5}};
        actualSquarelotron = squarelotron.upsideDownFlip(5);
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test the flip using the second ring.
     */
    @Test
    public void testUpSideDownFlipSecondRing() {
        int[][] expected = {{1,2,3,4,5},{6,17,18,19,10},{11,12,13,14,15},{16,7,8,9,20},{21,22,23,24,25}};
        actualSquarelotron = squarelotron.upsideDownFlip(4);
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test the flip using the second ring.
     */
    @Test
    public void testUpSideDownFlipThirdRing() {
        int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        actualSquarelotron = squarelotron.upsideDownFlip(3);
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test a diagonal flip with size 2 on the first and only ring.
     */
    @Test
    public void testMainDiagonalFlipSize2With1Ring() {

        final int localSize = 2;
        final int ring = 2;
        Squarelotron square = new Squarelotron(localSize);
        actualSquarelotron = square.mainDiagonalFlip(ring);
        int[][] expected = {{1, 3},{2, 4}};
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test a diagonal flip with size 3 on the first and only ring.
     */
    @Test
    public void testMainDiagonalFlipSize3With1Ring() {

        final int localSize = 3;
        final int ring = 3;
        Squarelotron square = new Squarelotron(localSize);
        actualSquarelotron = square.mainDiagonalFlip(ring);
        int[][] expected = {{1, 4, 7},{2, 5, 8},{3, 6, 9}};
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test a diagonal flip with size 5 on the first ring.
     */
    @Test
    public void testMainDiagonalFlipSize5With1Ring() {

        final int localSize = 5;
        final int ring = 5;
        Squarelotron square = new Squarelotron(localSize);
        actualSquarelotron = square.mainDiagonalFlip(ring);
        int[][] expected = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This method will test a diagonal flip with size 5 on the second ring.
     */
    @Test
    public void testMainDiagonalFlipSize5With2Ring() {

        final int localSize = 5;
        final int ring = 4;
        Squarelotron square = new Squarelotron(localSize);
        actualSquarelotron = square.mainDiagonalFlip(ring);
        int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }

    /**
     * This test will verify the rotation clockwise.
     */
    @Test
    public void testRotateRightClockWise2Times() {

        int[][] expected = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        final int localSize = 3;
        final int times = 2;
        Squarelotron square = new Squarelotron(localSize);
        square.rotateRight(times);
        assert Arrays.deepEquals(square.squarelotron, expected);
    }

    /**
     * This test will verify rotation counter clockwise.
     */
    @Test
    public void testRotateRightCounterClockWiseMinus3Times() {

        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        final int localSize = 3;
        final int times = -3;
        Squarelotron square = new Squarelotron(localSize);
        square.rotateRight(times);
        assert Arrays.deepEquals(square.squarelotron, expected);
    }

    /**
     * This test will verify rotation of zero times
     */
    @Test
    public void testRotateRightWithZeroMoves() {

        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int localSize = 3;
        final int times = 0;
        Squarelotron square = new Squarelotron(localSize);
        square.rotateRight(times);
        assert Arrays.deepEquals(square.squarelotron, expected);
    }




    @Test
    public void testRotateRight1() {
        //    Failed: arrays first differed at element [0]; expected:<3> but was:<9>
    }
    @Test
    public void testRotateRight2() {
        //    Failed: arrays first differed at element [0]; expected:<2> but was:<3>
    }
    @Test
    public void testRotateRight6() {
        //null
    }
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        //null

        final int localSize = 5;
        final int ring = 3;
        Squarelotron square = new Squarelotron(localSize);
        actualSquarelotron = square.mainDiagonalFlip(ring);
        int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 18, 23},
                {16, 17, 14, 19, 20}, {21, 22, 15, 24, 25}};
        int[][] actual = actualSquarelotron.squarelotron;
        printResult(localSize, actual);
        assert Arrays.deepEquals(actual, expected);
    }
    @Test
    public void testUpsideDownFlipDimensionFour() {
        //null

        int[][] expected = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        final int localSize = 4;
        Squarelotron actualSquare = new Squarelotron(localSize);
        squarelotron = actualSquare.upsideDownFlip(2);
        assert Arrays.deepEquals(squarelotron.squarelotron, expected);
    }

    @Test
    public void testUpsideDownFlipDimensionThree() {

        int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        final int localSize = 3;
        Squarelotron actualSquare = new Squarelotron(localSize);
        squarelotron = actualSquare.upsideDownFlip(1);
        assert Arrays.deepEquals(squarelotron.squarelotron, expected);

    }

    public void printResult(int localSize, int[][] squarelotron) {

        for (int i = 0; i < localSize; i++) {
            for (int j = 0; j < localSize; j++) {
                System.out.print(squarelotron[i][j] + " ");
            }
            System.out.println();
        }
    }
}
