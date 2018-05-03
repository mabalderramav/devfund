package org.minions.devfund.lourdes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void testAddMovie() {
        String name="Robert Downey";
        Actor actor = new Actor(name);
        Movie movie = new Movie("Iron Man I");
        actor.addMovie(movie);
        assertEquals(actor.getMovies().get(0),movie);
    }

    @Test
    public void testAverageRating() {
        String name="Robert Downey";
        Actor actor = new Actor(name);
        Movie movie1 = new Movie("Iron Man I");
        movie1.setRating(45);
        actor.addMovie(movie1);
        Movie movie2 = new Movie("Avengers");
        movie2.setRating(50.8);
        actor.addMovie(movie2);
        double expected_average = (45+50.8)/2;
        assertEquals(actor.averageRating(),expected_average, 0);
    }
}