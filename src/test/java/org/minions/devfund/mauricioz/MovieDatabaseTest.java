package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * suit of unit tests for movie database class.
 */
public class MovieDatabaseTest {
    private MovieDatabase movieDB;
    private String movieName;
    private String[] actor;
    private Actor newActor;

    /**
     * before test cases setup.
     */
    @Before
    public void setUp() {
        movieDB = new MovieDatabase();
        movieName = "Sleepers";
        actor = new String[] {"Brad Pitt"};
        movieDB.addMovie(movieName, actor);
        newActor = new Actor();
        newActor.setName(actor[0]);

    }

    /**
     * test if object is instance of moviedatabase class.
     */
    @Test
    public void testIsInstanceOfMovieDatabaseClass() {
        assertThat(movieDB, instanceOf(MovieDatabase.class));
    }

    /**
     * test is possible add one movie.
     */
    @Test
    public void testAddMovie() {
        assertEquals(movieName, movieDB.getMovieList().get(0).getName());
        assertEquals(newActor.getName(), movieDB.getActorList().get(0).getName());
    }

    /**
     * test add rating to a movie.
     */
    @Test
    public void testAddRating() {
        final double rating = 5.0;
        movieDB.addRating(movieName, rating);
        assertEquals(rating, movieDB.getMovieList().get(0).getRating());
    }

    /**
     * test update movie rating.
     */
    @Test
    public void testUpdateRating() {
        final double ratingUpdated = 8.0;
        movieDB.updateRating(movieName, ratingUpdated);
        assertEquals(ratingUpdated, movieDB.getMovieList().get(0).getRating());
    }

}
