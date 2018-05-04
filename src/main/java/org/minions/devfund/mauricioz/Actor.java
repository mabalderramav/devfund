package org.minions.devfund.mauricioz;

import java.util.ArrayList;

/**
 * Actor Class.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor.
     */
    public Actor() {
        this.name = "";
        this.movies = new ArrayList<Movie>();
    }

    /**
     * get actorn name.
     * @return actor name
     */
    public String getName() {
        return name;
    }

    /**
     * set actor name.
     * @param name actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * get movies where actor worked.
     * @return list of movies.
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * set movies list.
     * @param movies list of movies
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
