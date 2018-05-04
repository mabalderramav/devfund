package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * This class is a set of unit tests for Actor class methods.
 *
 * @author Mauricio Zelaya
 * @version 1.0
 */
public class ActorTest {
    private Actor actor;

    /**
     * before setup of execution.
     */
    @Before
    public void setUp() {
        actor = new Actor();
    }
    /**
     * test that actor created is an instance of Actor class.
     */
    @Test
    public void testActorIsInstanceOfActorClass() {

        assertThat(actor, instanceOf(Actor.class));
    }

    /**
     * testing getter and setter for name.
     */
    @Test
    public void testIsPossibleChangeAnActorName() {
        String newName = "new Name";
        actor.setName(newName);
        assertEquals(newName, actor.getName());
    }
}
