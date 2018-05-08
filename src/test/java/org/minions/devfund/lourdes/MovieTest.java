package org.minions.devfund.lourdes;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link Movie}.
 */
public class MovieTest {
    /**
     * Verify Movie constructor.
     */
    @Test
    public void testMovieConstructor() {
        final String movieName = "Iron Man I";
        Movie movie = new Movie(movieName);
        assertEquals(movie.getName(), movieName);
    }

    /**
     * Verify Movie constructor with empty params.
     */
    @Test
    public void testMovieConstructorEmptyParam() {
        Movie movie = new Movie();
        assertEquals(movie.getName(), "");
    }

    /**
     * Verify Add actor to a movie.
     */
    @Test
    public void addActorOne() {
        final String actorName = "Robert Downey";
        final String movieName = "Iron Man I";
        Actor actor = new Actor(actorName);
        final ArrayList<Actor> actors = new ArrayList<>();
        actors.add(actor);
        Movie movie = new Movie(movieName);
        movie.setActors(actors);
        assertEquals(movie.getActors().get(0).getName(), actorName);
    }

    /**
     * Verify set Movie Name.
     */
    @Test
    public void testSetName() {
        final String movieName = "Terminator";
        Movie movie = new Movie();
        movie.setName(movieName);
        assertEquals(movie.getName(), movieName);
    }
}
