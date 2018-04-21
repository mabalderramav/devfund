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
        int[][] expected = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        actualSquarelotron = squarelotron.upsideDownFlip(3);
        int[][] actual = actualSquarelotron.squarelotron;
        assert Arrays.deepEquals(actual, expected);
    }
}
