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

        for(int i = 0; i < localSize; i++) {
            for(int j = 0; j < localSize; j++) {
                System.out.print(actual[i][j]);
            }
            System.out.println();
        }
        assert Arrays.deepEquals(actual, expected);
    }
}
