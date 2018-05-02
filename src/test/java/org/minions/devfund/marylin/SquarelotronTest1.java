package org.minions.devfund.marylin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * SquarelotronTest1 class.
 */
class SquarelotronTest1 {

    @Before
    void setUp() throws Exception {

    }

    @Test
    void testTwoByTwoGrid() {
        //int[][] testGrid = {{3, 4}, {1, 2}};
        int[][] testGrid = {{1, 2}, {3, 4}};
        Squarelotron squarelotron = new Squarelotron(2);
        Squarelotron expected = new Squarelotron(testGrid);
        Squarelotron actual = squarelotron.upsideDownFlip(1);
        assertEquals(expected, actual);
    }

}
