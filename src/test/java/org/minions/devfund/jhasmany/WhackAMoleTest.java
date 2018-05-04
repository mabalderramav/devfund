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
		this.whackAMole = new WhackAMole(4, 7);
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
        assertEquals("The coordinates are valid.", 0, this.whackAMole.getAttemptsLeft());
    }
	
	@Test
    public void testRightWhack() {
		this.whackAMole.place(0, 0);
        this.whackAMole.whack(0, 0);
        assertEquals("The whack is wrong.", 'W', this.whackAMole.getMoleGrid()[0][0]);
    }
	
	@Test
    public void testWrongWhack() {
		this.whackAMole.place(0, 0);
        this.whackAMole.whack(1, 0);
        assertEquals("The whack is right.", 3, this.whackAMole.getAttemptsLeft());
    }
}
