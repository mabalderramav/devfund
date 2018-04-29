package org.minions.devfund.alejandro.movie.database;

import java.util.ArrayList;

/**
 * This class contains the information about the movies.
 */
public class Movie {
    private String name;
    private ArrayList<Actor>actors;
    private double rating;

    public Movie(String name) {
        this.name = name;
        this.actors = new ArrayList<Actor>();
    }

    /**
     * This method return the name of the movie.
     * @return the name of the movie.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method will return the list of actors that perform in the movie.
     * @return an ArrayList.
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * This method return the rating of the movie.
     * @return double.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * This method set a rating for the movie.
     * @param newRating the new rating for the movie.
     */
    public void setRating(double newRating) {
        this.rating = newRating;
    }

    /**
     * This method will set a new name to the movie.
     * @param newName an string that will change the name.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * This method will add a new actor to the movie.
     * @param actor an object for the actor instance.
     */
    public void addNewActor(Actor actor) {
        this.actors.add(actor);
    }
}
