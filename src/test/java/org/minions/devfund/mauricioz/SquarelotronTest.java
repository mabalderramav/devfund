package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * unit test class.
 */
public class SquarelotronTest {
    private static final int INITIAL_VALUE = 3;
    private Squarelotron squarelotron;

    /**
     * initialize squarelotron object.
     */
    @Before
    public void setUp() {
        squarelotron = new Squarelotron(INITIAL_VALUE);
    }

    /**
     * test if object is instance of the class correctly.
     */
    @Test
    public void testIsInstanceOfSquarelotron() {
        assertTrue(squarelotron instanceof Squarelotron);
    }
}
