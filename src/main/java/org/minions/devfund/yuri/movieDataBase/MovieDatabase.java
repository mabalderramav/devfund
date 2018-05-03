package org.minions.devfund.yuri.movieDataBase;

import java.util.ArrayList;

/**
 * Represents a  movie database with attributes and behavior.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor Method..
     */
    public MovieDatabase() {
        movieList = new ArrayList<Movie>();
        actorList = new ArrayList<Actor>();
    }

    public void addMovie(final String name, final String[] actors) {
        for (String actor:actors) {
            new A
        }
        movieList.add(new Movie(name, new ArrayList<Actor>() ))

    }

    public ArrayList<Movie> getMovieList(){
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }
}
