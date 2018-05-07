package org.minions.devfund.lourdes;

import java.util.ArrayList;

/**
 * Class that manage the movie information.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor.
     */
    public MovieDatabase() {
        this.movieList = new ArrayList<Movie>();
        this.actorList = new ArrayList<Actor>();
    }

    /**
     * Method to add a new movie to the movie list.
     *
     * @param name   represents the movie name.
     * @param actors actor list from a movie.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = createMovie(name);
        ArrayList<Actor> movieActors = new ArrayList<Actor>();
        for (String actorName : actors) {
            Actor actor = createActor(actorName);
            actor.addMovie(movie);
            movieActors.add(actor);
        }
        movie.setActors(movieActors);
    }

    /**
     * Method that create a new new movie object.
     *
     * @param movieName represents the movie name.
     * @return return the created movie.
     */
    public Movie createMovie(final String movieName) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        Movie movie = new Movie(movieName);
        movieList.add(movie);
        return movie;
    }

    /**
     * Method that create a new Actor object.
     *
     * @param actorName represents the actor name to be created.
     * @return the created actor.
     */
    public Actor createActor(final String actorName) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                return actor;
            }
        }
        Actor newActor = new Actor(actorName);
        actorList.add(newActor);
        return newActor;
    }

    /**
     * Method that add a rating to a given movie.
     *
     * @param name   represents the movie name.
     * @param rating rating of the movie.
     */
    public void addRating(final String name, final double rating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            }
        }
    }

    /**
     * Method that update the rating of the given movie name.
     *
     * @param name      represents the movie name.
     * @param newRating the new rating to be set.
     */
    public void updateRating(final String name, double newRating) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(newRating);
            }
        }
    }

    /**
     * Method that return the best Actor.
     *
     * @return the best actor.
     */
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

    /**
     * Method that return the best movie fo the list.
     *
     * @return the best movie.
     */
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

    /**
     * Method that return the movie list.
     *
     * @return the movie list.
     */

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Method that get the actor List.
     *
     * @return return the actor List.
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /**
     * Method that get an actor bye name.
     *
     * @param actorName the name of the actor.
     * @return the actor object.
     */
    public Actor getActorByName(final String actorName) {
        return actorList.stream()
                .filter(actor -> actorName.equals(actor.getName()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Method that return a movie given a name.
     *
     * @param movieName represents the movie name.
     * @return the movie object.
     */
    public Movie getMovieByName(final String movieName) {
        return movieList.stream()
                .filter(movie -> movieName.equals(movie.getName()))
                .findFirst()
                .orElse(null);
    }

}
