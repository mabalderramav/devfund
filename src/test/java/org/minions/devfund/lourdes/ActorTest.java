package org.minions.devfund.lourdes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link Actor}.
 */
public class ActorTest {
    private static final String ACTOR_NAME = "Robert Downey";

    /**
     * Verify actor constructor with empty params.
     */
    @Test
    public void testActorConstructor() {
        Actor actor = new Actor();
        assertEquals(actor.getName(), "");
    }

    /**
     * Verify Add movie to an actor.
     */
    @Test
    public void testAddMovie() {
        final Actor actor = new Actor(ACTOR_NAME);
        Movie movie = new Movie("Iron Man I");
        actor.addMovie(movie);
        assertEquals(actor.getMovies().get(0), movie);
    }

    /**
     * Verify the average rating for an actor.
     */
    @Test
    public void testAverageRating() {
        final double ratingMovie1 = 45;
        final double ratingMovie2 = 50.8;
        Actor actor = new Actor(ACTOR_NAME);
        Movie movie1 = new Movie("Iron Man I");
        movie1.setRating(ratingMovie1);
        actor.addMovie(movie1);
        Movie movie2 = new Movie("Avengers");
        movie2.setRating(ratingMovie2);
        actor.addMovie(movie2);
        double expectedAverage = (ratingMovie1 + ratingMovie2) / 2;
        assertEquals(actor.averageRating(), expectedAverage, 0);
    }

    /**
     * Verify set movies in the list.
     */
    @Test
    public void testSetMovies() {
        final String movieName = "Iron Man II";
        Actor actor = new Actor(ACTOR_NAME);
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie(movieName);
        movieList.add(movie);
        actor.setMovies(movieList);
        assertEquals(actor.getMovies().get(0).getName(), movieName);

    }
}
