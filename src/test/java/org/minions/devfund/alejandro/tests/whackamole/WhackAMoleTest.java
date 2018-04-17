package org.minions.devfund.alejandro.tests.whackamole;
import org.minions.devfund.alejandro.WhackAMole;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class contain the test cases for WhackAMole class.
 */

public class WhackAMoleTest {

    private final int numAttempts = 10;
    private final int gridDimension = 4;
    private int xPosition = 2;
    private int yPosition = 2;
    private final String expectedChar = "****\n****\n****\n****\n";
    private final String expectedCharMoles = "****\n****\n**M*\n****\n";
    private final String expectedCharWhacks = "****\n****\n**W*\n****\n";
    private WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);


    /**
     * This test will verify that the instance of WhackAMole is created.
     */
    @Test
    public void testWhackAMoleConstructor() {
        assertThat(this.whackAMole, instanceOf(WhackAMole.class));
    }

    /**
     * This test will verify that moles can be placed.
     */
    @Test
    public void testPlaceValidLocationMoles() {

        boolean actual = whackAMole.place(xPosition, yPosition);
        assert actual;
    }

    /**
     * This test will verify that moles can not be placed in the same place.
     */
    @Test
    public void testPlaceInvalidLocationMoles() {

        whackAMole.place(xPosition, yPosition);
        boolean actual = whackAMole.place(xPosition, yPosition);
        assert !actual;
    }

    /**
     * This test will verify that moles are placed in moleGrid.
     */
    @Test
    public void testMoleIsPlacedInMoleGrid() {

        whackAMole.place(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert actual.equals(expectedCharMoles);
    }

    /**
     * This test will verify that place method add a moleLeft.
     */
    @Test
    public void testMolesLeftAreUpdated() {

        whackAMole.place(xPosition, yPosition);
        int moleLefts = whackAMole.getMolesLeft();
        assert moleLefts == 1;
    }

    /**
     * This test will verify that a whack is placed.
     */
    @Test
    public void testMakeAValidWhack() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert expectedCharWhacks.equals(actual);
    }

    /**
     * This test will verify that a whack is not placed for an invalid place.
     */
    @Test
    public void testMakeAnInvalidWhack() {

        whackAMole.whack(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert expectedChar.equals(actual);
    }

    /**
     * This test will verify that a whack update the score.
     */
    @Test
    public void testWhackUpdatesScore() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        int actual = whackAMole.getScore();
        assert actual == 1;
    }

    /**
     * This test will verify that a whack update the attemptsLeft.
     */
    @Test
    public void testWhackUpdatesAttemptsLefts() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        int actual = whackAMole.getAttemptsLeft();
        assert actual == numAttempts - 1;
    }

    /**
     * This method will test the print of the grid for the user,
     * using a default position where a mole be placed.
     */
    @Test
    public void testPrintGridForUsers() {

        assert expectedChar.equals(whackAMole.printGridToUser());
    }

    /**
     * This method will test the print of the grid,
     * using a default position where a mole be placed.
     */
    @Test
    public void testPrintGridWithMoles() {

        whackAMole.place(xPosition, yPosition);
        assert expectedCharMoles.equals(whackAMole.printGrid());
    }

    /**
     * This method will test the print of the grid,
     * using a default position where a whack is placed.
     */
    @Test
    public void testPrintGridWithWhacks() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        assert expectedCharWhacks.equals(whackAMole.printGrid());
    }
}
