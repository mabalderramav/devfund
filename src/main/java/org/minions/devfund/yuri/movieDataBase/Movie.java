package org.minions.devfund.yuri.movieDataBase;

import java.util.ArrayList;

/**
 * Represents a Movie with all attributes and behavior.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Constructor method.
     *
     * @param name   movie name.
     * @param actors actors list.
     */
    public Movie(final String name, final ArrayList<Actor> actors) {
        this.name = name;
        this.actors = actors;
    }

    /**
     * Sets the movie name.
     *
     * @param name the new name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the movie rating.
     *
     * @param rating new rating value.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }
}
