package org.minions.devfund.yuri.movieDataBase;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Verifies all the functionality of Movie data base.
 */
public class MovieDatabaseTest {

  public static final int RATING = 10;

  /**
   * Verifies that is possible to add a movie that is not in the db.
   */
  @Test
  public void testAddMovieNotInDb() {
    MovieDatabase movieDatabase = new MovieDatabase();
    movieDatabase.addMovie("test", new String[]{"Yuri", "Agus"});
    Movie expectedMovie = new Movie("test", RATING, new ArrayList<Actor>());
    assertTrue(movieDatabase.getMovieList().contains(expectedMovie));
  }
}
