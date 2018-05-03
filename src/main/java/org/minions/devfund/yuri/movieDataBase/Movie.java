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
     */
    public Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<>();
    }

    /**
     * Gets actor list.
     * @return actors list.
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }
    /**
     * Gets the movie name.
     * @return movie name.
     */
    public String getName() {
        return name;
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
     * Gets the movie rating.
     * @return movie rating.
     */
    public double getRating() {
        return rating;
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
