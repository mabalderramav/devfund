package org.minions.devfund.lourdes;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieDatabaseTest {

    private MovieDatabase movieDatabase;
    private String movieName;
    private String[] actors ;

    @Before
    public void setup(){
        movieDatabase = new MovieDatabase();
        movieName = "Sexto sentido";
        actors = new String[]{"Bruce Willis", "Haley Joel"};
    }

    @Test
    public void testAddMovieNew() {
        MovieDatabase movieDatabase = new MovieDatabase();
        movieDatabase.addMovie(movieName, actors);
        assertEquals(movieDatabase.getMovieList().get(0).getName(),movieName);
    }

    @Test
    public void testAddMovieExist() {
        String movieNameExist = "Sexto sentido";
        movieDatabase.addMovie(movieNameExist, actors);
        assertEquals(movieDatabase.getMovieList().size(), 1);
    }

    @Test
    public void testAddMovieActorNew() {
        String movieName = "Duro de Matar";
        Movie movie = new Movie(movieName);
        String[] actors = new String[]{"Bruce Willis","Alam Rickman"};
        movieDatabase.addMovie(movieName,actors);
        List<Movie> movieList = movieDatabase.getMovieList();
        assertEquals(movieList.size(),1);

    }

    @Test
    public void testAddMovieActorExist() {

    }
    @Test
    public void testAddExistMovieWithNewActor() {

    }

    @Test
    public void testIsNewActor() {
    }

    @Test
    public void testAddRating() {
    }

    @Test
    public void testUpdateRating() {
    }

    @Test
    public void testGetBestActor() {
    }

    @Test
    public void testGetBestMovie() {
    }
}