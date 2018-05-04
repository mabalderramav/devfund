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

    /**
     * before test cases setup.
     */
    @Before
    public void setUp() {
        movieDB = new MovieDatabase();
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
        String movieName = "Sleepers";
        String[] actor = {"Brad Pitt"};
        movieDB.addMovie(movieName, actor);
        assertEquals(movieName, movieDB.getMovieList().get(0).getName());
    }

}
