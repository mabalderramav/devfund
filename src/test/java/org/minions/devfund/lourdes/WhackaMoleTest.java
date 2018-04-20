package org.minions.devfund.lourdes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for Test for {@link WhackAMole}.
 */
public class WhackaMoleTest {

    private WhackAMole whackAMole;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        final int numAttempts = 50;
        final int gridDimension = 10;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
    }

    /**
     * Verify that a Mole is placed in the given position.
     */
    @Test
    public void testPlaceMole() {
        final int positionX = 6;
        final int positionY = 5;
        assertTrue(whackAMole.place(positionX, positionY));
    }

    /**
     * Verify that a Mole is not assigned in a position that has been already assigned.
     */
    @Test
    public void testPlaceMoleInSamePosition() {
        final int positionX = 1;
        final int positionY = 2;
        whackAMole.place(positionX, positionY);
        assertFalse(whackAMole.place(positionX, positionY));
    }

    /**
     * Verify a whack is done in the given position.
     */
    @Test
    public void testWhack() {
        final int positionX = 4;
        final int positionY = 3;
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        char[][] grid = whackAMole.getMoleGrid();
        assertEquals(grid[positionX][positionY], 'W');
    }

    /**
     * Verify the score is incremented when a whack is successful.
     */
    @Test
    public void testScore() {
        final int positionX = 2;
        final int positionY = 3;
        int score = whackAMole.getScore();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getScore(), score + 1);
    }

    /**
     * Verify the attempts are decreased when a whack is made.
     */
    @Test
    public void testAttempts() {
        final int positionX = 3;
        final int positionY = 6;
        int attempts = whackAMole.getAttemptsLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getAttemptsLeft(), attempts - 1);
    }

    /**
     * Method that validate how a Grid should be displayed to an User.
     */
    @Test
    public void testPrintGridToUser() {
        final String asteriskLine = "**********\n";
        StringBuilder gridToUser = new StringBuilder();
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append("********W*\n");
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        gridToUser.append(asteriskLine);
        final int positionX1 = 0;
        final int positionY1 = 5;
        final int positionX2 = 5;
        final int positionY2 = 8;
        whackAMole.place(positionX1, positionY1);
        whackAMole.place(positionX2, positionY2);
        whackAMole.whack(positionX2, positionY2);
        assertEquals(whackAMole.printGridToUser(), gridToUser.toString());
    }

    /**
     * Method that validate how a Grid should be displayed when game ends.
     */
    @Test
    public void printGrid() {
        final String asteriskLine = "**********\n";
        StringBuilder grid = new StringBuilder();
        grid.append("*****M****\n");
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        grid.append("********W*\n");
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        grid.append(asteriskLine);
        final int positionX1 = 0;
        final int positionY1 = 5;
        final int positionX2 = 5;
        final int positionY2 = 8;
        whackAMole.place(positionX1, positionY1);
        whackAMole.place(positionX2, positionY2);
        whackAMole.whack(positionX2, positionY2);
        assertEquals(whackAMole.printGrid(), grid.toString());
    }
}
