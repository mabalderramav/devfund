package org.minions.devfund.lourdes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link Actor}.
 */
public class ActorTest {

    /**
     * Verify Add movie to an actor.
     */
    @Test
    public void testAddMovie() {
        final String name = "Robert Downey";
        final Actor actor = new Actor(name);
        Movie movie = new Movie("Iron Man I");
        actor.addMovie(movie);
        assertEquals(actor.getMovies().get(0), movie);
    }

    /**
     * Verify the average rating for an actor.
     */
    @Test
    public void testAverageRating() {
        final String name = "Robert Downey";
        final double ratingMovie1 = 45;
        final double ratingMovie2 = 50.8;
        Actor actor = new Actor(name);
        Movie movie1 = new Movie("Iron Man I");
        movie1.setRating(ratingMovie1);
        actor.addMovie(movie1);
        Movie movie2 = new Movie("Avengers");
        movie2.setRating(ratingMovie2);
        actor.addMovie(movie2);
        double expectedAverage = (ratingMovie1 + ratingMovie2) / 2;
        assertEquals(actor.averageRating(), expectedAverage, 0);
    }
}
