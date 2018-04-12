package org.minions.devfund.roy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for WhackAMole class.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;
    private static final int POSITION_X = 4;
    private static final int POSITION_Y = 7;
    private static final int POSITION_X_1 = 3;
    private static final int POSITION_Y_1 = 5;
    private static final int POSITION_X_2 = 2;
    private static final int POSITION_Y_2 = 1;
    private static final int ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;

    /**
     * Preconditions.
     */
    @Before
    public void before() {
        whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Test for whackAMole.place method.
     */
    @Test
    public void place() {
        Assert.assertTrue(whackAMole.place(POSITION_X, POSITION_Y));
    }

    /**
     * Test for whack method.
     */
    @Test
    public void whack() {
        whackAMole.whack(POSITION_X, POSITION_Y);
    }

    /**
     * Test for printGridToUser Method.
     */
    @Test
    public void printGridToUser() {
        whackAMole.whack(POSITION_X, POSITION_Y);
        whackAMole.printGridToUser();
    }

    /**
     * Test for printGrid Method.
     */
    @Test
    public void printGrid() {
        whackAMole.whack(POSITION_X, POSITION_Y);
        whackAMole.whack(POSITION_X_1, POSITION_Y_1);
        whackAMole.whack(POSITION_X_2, POSITION_Y_2);
        whackAMole.printGridToUser();
    }

    /**
     * Test for playGame method.
     */
    @Ignore
    @Test
    public void playGame() {
        whackAMole.playGame();
    }

    /**
     * Test for initializeGrid method.
     */
    @Test
    public void initializeGrid() {
        whackAMole.initializeGrid();
    }

    /**
     * Test for printGridAndScore method.
     */
    @Test
    public void printGridAndScore() {
        whackAMole.whack(POSITION_X, POSITION_Y);
        whackAMole.whack(POSITION_X_1, POSITION_Y_1);
        whackAMole.whack(POSITION_X_2, POSITION_Y_2);
        whackAMole.printGridAndScore();
    }
}
