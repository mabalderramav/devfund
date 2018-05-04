package org.minions.devfund.jhasmany;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WhackAMoleTest {
    private WhackAMole whackAMole;

    @Before
    public void setup() {
	this.whackAMole = new WhackAMole(4, 3);
    }

    @Test
    public void testFreePlace() {
	assertTrue("The place isn't free.", this.whackAMole.place(0, 0));
    }

    @Test
    public void testOccupiedPlace() {
	this.whackAMole.place(0, 0);

	assertFalse("The place is free.", this.whackAMole.place(0, 0));
    }

    @Test
    public void testOutOfRangeWhack() {
	this.whackAMole.whack(10, 10);
	int expectedResult = 0;
	int actualResult = this.whackAMole.getAttemptsLeft();

	assertEquals("The coordinates are valid.", expectedResult, actualResult);
    }

    @Test
    public void testRightWhack() {
	this.whackAMole.place(0, 0);
	this.whackAMole.whack(0, 0);
	char expectedTesult = 'W';
	char actualResult = this.whackAMole.getMoleGrid()[0][0];

	assertEquals("The whack is wrong.", expectedTesult, actualResult);
    }

    @Test
    public void testWrongWhack() {
	this.whackAMole.place(0, 0);
	this.whackAMole.whack(1, 0);
	int expectedResult = 3;
	int actualResult = this.whackAMole.getAttemptsLeft();

	assertEquals("The whack is right.", expectedResult, actualResult);
    }

    @Test
    public void testPutTheMoles() {
	this.whackAMole.putTheMoles(3);
	int expectedResult = 3;
	int actualResult = this.whackAMole.getMolesLeft();

	assertEquals("There is a difference with moles", expectedResult, actualResult);
    }

    @Test
    public void testForPutTheMolesIncorrect() {
	this.whackAMole.putTheMoles(3);
	int expectedResult = 2;
	int actualResult = this.whackAMole.getMolesLeft();

	assertFalse("There isn't a difference with moles", expectedResult == actualResult);
    }
}
