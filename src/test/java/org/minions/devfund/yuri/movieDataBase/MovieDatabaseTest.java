package org.minions.devfund.yuri.movieDataBase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Verifies all the functionality of Movie data base.
 */
public class MovieDatabaseTest {
  /**
   * Verifies that is possible to add a movie that is not in the db.
   */
  @Test
  public void testAddMovieNotInDb() {
    final int movieSizeExpected = 1;
    MovieDatabase movieDatabase = new MovieDatabase();
    movieDatabase.addMovie("test", new String[]{"Yuri", "Agus"});
    final int movieSizeActual = movieDatabase.getMovieList().size();
    assertEquals(movieSizeExpected, movieSizeActual);
  }
}
