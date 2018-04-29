package org.minions.devfund.alejandro.movie.database;

import org.junit.Test;
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
        final String movieName = "movie123";
        Actor actor = new Actor(actorName);
        Movie movie = new Movie(movieName);
        actor.setNewMovie(movie);
        System.out.println(actor.getMovies());
        System.out.println(movie);

        assert actor.getMovies().equals(movie);
    }
}
