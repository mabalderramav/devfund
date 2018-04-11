package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is a set of unit tests for Whackamole class methods.
 *
 * @author Mauricio Zelaya
 * @version 1.0
 */
public class WhackAMoleTest {

    private WhackAMole whackamole;
    private static final int ATTEMPTS_NUMBER = 50;
    private static final int BOARD_DIMENSION = 10;

    /**
     * Initialization of the whackamole board.
     */
    @Before
    public void setUp() {

        whackamole = new WhackAMole(ATTEMPTS_NUMBER, BOARD_DIMENSION);

    }

    /**
     * Test initial value of moles in the board is 10.
     */
    @Test
    public void testWackamoleStartWith10Moles() {

        assertTrue(whackamole.getMolesLeft() == BOARD_DIMENSION);

    }

    /**
     * Test initial value of attempts remaining is 50.
     */
    @Test
    public void testWhackAMoleStartWith50AttemptsRemaining() {

        assertEquals(ATTEMPTS_NUMBER, whackamole.getAttemptsLeft());

    }

    /**
     * Test initial grid displayed to the user shows only *.
     */
    @Test
    public void testInitialWhackAMoleBoardShowsOnlyStars() {

        boolean isStar = false;
        for (int i = 0; i < whackamole.getMoleGridLength(); i++) {
            for (int j = 0; j < whackamole.getMoleGridLength(); j++) {
                if (whackamole.getMoleGrid(i, j) == '*' || whackamole.getMoleGrid(i, j) == 'M') {
                    isStar = true;
                }
            }
        }
        assertTrue(isStar);
    }
}
