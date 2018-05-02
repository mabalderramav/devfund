package org.minions.devfund.angela.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link MovieDatabase}.
 */
public class MovieDatabaseTest {

    private MovieDatabase movieDatabase;
    private static final String MOVIE_NAME = "Infinity War";
    private static final String BEST_ACTOR = "Robert Downey";
    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        movieDatabase = new MovieDatabase();
        movieDatabase.addMovie(MOVIE_NAME, new String[]{BEST_ACTOR, "Chris Hemsworth", "Chris Evans"});
    }

    /**
     * Verifies all actors where added.
     */
    @Test
    public void testActorsAdded() {
        final List<Actor> actors = new ArrayList<>();
        actors.add(new Actor(BEST_ACTOR));
        actors.add(new Actor("Chris Hemsworth"));
        actors.add(new Actor("Chris Evans"));
        for (Actor actor : actors) {
            assertTrue("The list doesn't contain the actor", movieDatabase.getActorList()
                    .stream().anyMatch(actor1 -> actor.getName().equalsIgnoreCase(actor1.getName())));
        }
    }

    /**
     * Verifies movie was added.
     */
    @Test
    public void testMovieAdded() {
        assertEquals(MOVIE_NAME, movieDatabase.getMovieList().get(0).getName());
    }

    /**
     * Verifies rating was added.
     */
    @Test
    public void testAddRating() {
        final double rating = 1.5;
        final double ratingToAdd = 1;
        this.movieDatabase.addRating(MOVIE_NAME, rating);
        this.movieDatabase.addRating(MOVIE_NAME, ratingToAdd);

        assertEquals(rating + ratingToAdd, movieDatabase.getMovieList().get(0).getRating(), 0);
    }

    /**
     * Verifies rating was updated.
     */
    @Test
    public void testUpdateRating() {
        final double rating = 1.5;
        final double ratingToUpdate = 1;
        this.movieDatabase.addRating(MOVIE_NAME, rating);
        this.movieDatabase.updateRating(MOVIE_NAME, ratingToUpdate);

        assertEquals(ratingToUpdate, movieDatabase.getMovieList().get(0).getRating(), 0);
    }

    /**
     * Verifies that gets the best actor.
     */
    @Test
    public void testGetBestActor() {
        assertEquals(BEST_ACTOR, movieDatabase.getBestActor());
    }

    /**
     * Verifies that gets the best movie.
     */
    @Test
    public void testGetBestMovie() {
        assertEquals(MOVIE_NAME, movieDatabase.getBestMovie());
    }
}
