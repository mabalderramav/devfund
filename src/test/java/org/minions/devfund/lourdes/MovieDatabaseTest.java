package org.minions.devfund.lourdes;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link MovieDatabase}.
 */
public class MovieDatabaseTest {

    private MovieDatabase movieDatabase;
    private String movieName1;
    private String[] actors1;

    /**
     * Method that setup all initial values.
     */
    @Before
    public void setup() {
        movieDatabase = new MovieDatabase();
        movieName1 = "Sexto sentido";
        actors1 = new String[]{"Bruce Willis", "Haley Joel"};
    }

    /**
     * Verify add new movie to the list.
     */
    @Test
    public void testAddMovie() {
        MovieDatabase movieDatabase = new MovieDatabase();
        movieDatabase.addMovie(movieName1, actors1);
        assertEquals(movieDatabase.getMovieList().get(0).getName(), movieName1);
    }

    /**
     * Verify add a duplicated movie.
     */
    @Test
    public void testAddExistMovie() {
        final int totalMovie = 1;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName1, actors1);
        assertEquals(movieDatabase.getMovieList().size(), totalMovie);
    }

    /**
     * Verify add a new movie with new actors.
     */
    @Test
    public void testAddMovieNewActors() {
        movieDatabase.addMovie(movieName1, actors1);
        assertEquals(actors1.length, movieDatabase.getActorList().size());
        for (String actor : actors1) {
            assertEquals(movieDatabase.getActorByName(actor).getName(), actor);
        }
    }

    /**
     * Verify add a second movie.
     */
    @Test
    public void testAddMovie2() {
        final String movieName2 = "Duro de Matar";
        final String[] actors2 = new String[]{"Bruce Willis", "Alam Rickman"};
        final int totalMovies = 2;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName2, actors2);
        List<Movie> movieList = movieDatabase.getMovieList();
        assertEquals(movieList.size(), totalMovies);
        for (Movie movie : movieList) {
            assertEquals(movieDatabase.getMovieByName(movie.getName()).getName(), movie.getName());
        }
    }

    /**
     * Verify Add second movie with existing actors.
     */
    @Test
    public void testAddNewMovieActorExist() {
        final String movieName2 = "Duro de Matar";
        final String[] actors2 = new String[]{"Bruce Willis", "Alam Rickman"};
        final int totalNumberActors = 3;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName2, actors2);
        List<Actor> actorList = movieDatabase.getActorList();
        assertEquals(movieDatabase.getActorList().size(), totalNumberActors);
        for (Actor actor : actorList) {
            assertEquals(movieDatabase.getActorByName(actor.getName()).getName(), actor.getName());
        }
    }

    /**
     * Verify to add duplicated Actors.
     */
    @Test
    public void testAddMovieDuplicatedActors() {
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName1, actors1);
        for (String actor : actors1) {
            assertEquals(movieDatabase.getActorByName(actor).getName(), actor);
        }
    }

    /**
     * Verify add rating.
     */
    @Test
    public void testAddRating() {
        final double rating = 23.4;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addRating(movieName1, rating);
        assertEquals(movieDatabase.getMovieByName(movieName1).getRating(), rating, 0);

    }

    /**
     * Verify update rating of a movie.
     */
    @Test
    public void testUpdateRating() {
        final double rating = 23.4;
        final double updaterating = 40.8;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addRating(movieName1, rating);
        movieDatabase.updateRating(movieName1, updaterating);
        assertEquals(movieDatabase.getMovieByName(movieName1).getRating(), updaterating, 0);
    }

    /**
     * Verify get best actor.
     */
    @Test
    public void testGetBestActor() {
        final String movieName2 = "Duro de Matar";
        final String[] actors2 = new String[]{"Bruce Willis", "Alam Rickman"};
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName2, actors2);
        assertEquals(movieDatabase.getBestActor(), "Bruce Willis");
    }

    /**
     * Verify get the best movie.
     */
    @Test
    public void testGetBestMovie() {
        final String movieName2 = "Duro de Matar";
        final String[] actors2 = new String[]{"Bruce Willis", "Alam Rickman"};
        final double ratingMovie1 = 23.4;
        final double ratingMovie2 = 44.6;
        movieDatabase.addMovie(movieName1, actors1);
        movieDatabase.addMovie(movieName2, actors2);

        movieDatabase.addRating(movieName1, ratingMovie1);
        movieDatabase.addRating(movieName2, ratingMovie2);
        assertEquals(movieDatabase.getBestMovie(), movieName2);
    }
}
