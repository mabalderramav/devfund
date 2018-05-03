package org.minions.devfund.lourdes;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void testMovieConstructor() {
        String movieName = "Iron Man I";
        Movie movie = new Movie(movieName);
        assertEquals(movie.getName(), movieName);
    }

    @Test
    public void addActorOne() {
        String actorName = "Robert Downey";
        String movieName = "Iron Man I";
        Movie movie = new Movie(movieName);
        movie.addActor(actorName);
        assertEquals(movie.getActors().get(0).getName(), actorName);
    }

}