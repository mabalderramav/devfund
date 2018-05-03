package org.minions.devfund.lourdes;

import java.util.ArrayList;

public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    public MovieDatabase() {
        this.movieList = new ArrayList<Movie>();
        this.actorList = new ArrayList<Actor>();
    }

    public void addMovie(String name, String[] actors) {
        Movie movie =  createMovie(name);
        ArrayList<Actor> movieActors = new ArrayList<Actor>();
        for (String actorName : actors) {
            Actor actor = createActor(actorName);
            actor.addMovie(movie);
            movieActors.add(actor);
        }
        movie.setActors(movieActors);
    }

    public Movie createMovie(String movieName){
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        Movie movie = new Movie(movieName);
        movieList.add(movie);
        return movie;
    }

    public Actor createActor(String actorName) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                return actor;
            }
        }
        Actor newActor = new Actor(actorName);
        actorList.add(newActor);
        return newActor;
    }


    public void addRating(String name, double rating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            }
        }
    }

    public void updateRating(String name, double newRating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(newRating);
            }
        }
    }

    public String getBestActor() {
        double highAverage = -1;
        String bestActor = "";
        for (Actor actor : actorList) {
            if (actor.averageRating() > highAverage) {
                highAverage = actor.averageRating();
                bestActor = actor.getName();
            }

        }
        return bestActor;
    }

    public String getBestMovie() {
        String bestMovie = "";
        double bestRating = -1;
        for (Movie movie : movieList) {
            if (movie.getRating() > bestRating) {
                bestRating = movie.getRating();
                bestMovie = movie.getName();
            }

        }
        return bestMovie;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(ArrayList<Actor> actorList) {
        this.actorList = actorList;
    }

}
