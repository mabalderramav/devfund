package org.minions.devfund.alejandro.movie.database;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ActorTests {

    @Test
    public void testActorConstructor() {
        final String actorName = "test123";
        Actor actor = new Actor(actorName);
        assertThat(actor, instanceOf(Actor.class));
    }

    @Test
    public void testActorGetName() {
        final String actorName = "test123";
        Actor actor = new Actor(actorName);
        assert actor.getName().equals(actorName);
    }

    @Test
    public void testActorGetNewName() {
        final String actorName = "test123";
        final String newActorName = "new name";
        Actor actor = new Actor(actorName);
        actor.setName(newActorName);
        assert actor.getName().equals(newActorName);
    }

    @Test
    public void testGetMovies() {
        final String actorName = "test123";
        final ArrayList<Actor> expectedArrayList = new ArrayList<>();
        Actor actor = new Actor(actorName);
        System.out.println(actor.getMovies());
        System.out.println(expectedArrayList);
        assert actor.getMovies().equals(expectedArrayList);
    }
}
