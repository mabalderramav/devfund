package org.minions.devfund.yuri.movieDataBase;

import java.util.ArrayList;

/**
 * Represents an Actor with all attributes and behavior.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor method.
     *
     * @param name   actor name.
     * @param movies movies list.
     */
    public Actor(final String name, final ArrayList<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    /**
     * Sets the name of the actor.
     *
     * @param name new actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the movies related with the actor.
     *
     * @param movies list of movies.
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Gets the actor name.
     *
     * @return actor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the actor movie list.
     *
     * @return the movie list.
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
