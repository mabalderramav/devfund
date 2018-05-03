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
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                return;
            }
        }

        Movie newMovie = new Movie(name);

        ArrayList<Actor> movieActors = new ArrayList<Actor>();
        for (String actorName : actors) {
            Actor newActor = new Actor(actorName);
            newActor.addMovie(newMovie);
            movieActors.add(newActor);

            if (isNewActor(actorName)) {
                actorList.add(newActor);
            }
        }

        newMovie.setActors(movieActors);
        movieList.add(newMovie);
    }

    public boolean isNewActor(String actorName) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                return true;
            }
        }
        return false;
    }


    public void addRating(String name, double rating) {
        for (Movie movie : movieList) {
            if(movie.getName().equals(name)){
                movie.setRating(rating);
            }
        }
    }

    public void updateRating(String name, double newRating) {
        for (Movie movie : movieList) {
            if(movie.getName().equals(name)){
                movie.setRating(newRating);
            }
        }
    }

    public String getBestActor() {
        double highAverage = -1;
        String bestActor = "";
        for (Actor actor:actorList) {
            if (actor.averageRating() > highAverage){
                highAverage = actor.averageRating();
                bestActor = actor.getName();
            }

        }
        return bestActor;
    }

    public String getBestMovie() {
        String bestMovie="";
        double bestRating = -1;
        for (Movie movie:movieList) {
            if(movie.getRating()>bestRating){
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
