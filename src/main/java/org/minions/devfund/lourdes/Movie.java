package org.minions.devfund.lourdes;

import java.util.ArrayList;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    public Movie(String name) {
        this.name = name;
        this.actors = new ArrayList<Actor>();
    }

    public Movie() {
        this("");
    }

    public void addActor(String actorName) {
        Actor newActor = new Actor(actorName);
        newActor.addMovie(this);
        actors.add(newActor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}
