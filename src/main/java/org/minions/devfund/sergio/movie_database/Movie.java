package org.minions.devfund.sergio.movie_database;

import java.util.ArrayList;

public class Movie {

    private String name;
    private ArrayList<Actor> actors = new ArrayList<>();

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

    public Movie(String MovieName) {
        name = MovieName;
    }
}
