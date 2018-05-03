package org.minions.devfund.yuri.movieDataBase;

import java.util.ArrayList;

/**
 * Represents a  movie database with attributes and behavior.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor Method.
     * @param movieList movie list.
     * @param actorList actor list.
     */
    public MovieDatabase(final ArrayList<Movie> movieList, final ArrayList<Actor> actorList) {
        this.movieList = movieList;
        this.actorList = actorList;
    }
}
