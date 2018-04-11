package org.minions.devfund.bruno;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This class in charged of testing the whack a mole game.
 */
public class WhackAMoleTest {

    private static final int NUM_ATTEMPTS = 10;
    private static final int GRID_DIMENSION = 10;

    /**
     * Verifies if the game working correctly.
     */
    @Test
    public void whackAMoleGameTest() {
        WhackAMole whackAMoleGame = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);

        whackAMoleGame.printGridToUser();
        whackAMoleGame.printGrid();
        assertTrue(whackAMoleGame.place(2, 3));
    }
}
