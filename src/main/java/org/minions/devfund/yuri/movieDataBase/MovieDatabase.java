package org.minions.devfund.yuri.movieDataBase;

import java.util.ArrayList;

/**
 * Represents a  movie database with attributes and behavior.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor Method..
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Adds a movie to list.
     *
     * @param name   movie name.
     * @param actors actors.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = new Movie(name);
        if (!movieList.contains(movie)) {
            movieList.add(movie);
            for (String actorName : actors) {
                Actor actor = new Actor(actorName);
                movie.getActors().add(actor);
                actor.getMovies().add(movie);
                if (!actorList.contains(actor)) {
                    actorList.add(actor);
                }
            }
        }
    }

    /**
     * Adds rating an specific movie.
     *
     * @param name   movie name.
     * @param rating movie rating.
     */
    public void addRating(final String name, final double rating) {
        if (movieList.indexOf(new Movie(name)) >= 0) {
            Movie movie = movieList.get(movieList.indexOf(new Movie(name)));
            movie.setRating(movie.getRating() + rating);
        }
    }

    /**
     * Updates the movie rating.
     *
     * @param name   movie name.
     * @param rating movie rating.
     */
    public void updateRating(final String name, final double rating) {
        if (movieList.indexOf(new Movie(name)) > 0) {
            Movie movie = movieList.get(movieList.indexOf(new Movie(name)));
            movie.setRating(rating);
        }
    }

    /**
     * Gets the actor with best average rating.
     *
     * @return best actor.
     */
    public String getBestActor() {
        Actor bestActor = new Actor();
        for (Actor actor : actorList) {
            if (actor.getAverage() > bestActor.getAverage()) {
                bestActor = actor;
            }
        }
        return bestActor.getName();
    }

    /**
     * Gets the movie with the highest rating.
     *
     * @return best movie.
     */
    public String getBestMovie() {
        Movie bestMovie = new Movie();
        for (Movie movie : movieList) {
            if (movie.getRating() > bestMovie.getRating()) {
                bestMovie = movie;
            }
        }
        return bestMovie.getName();
    }


    /**
     * Gets movie list.
     *
     * @return movie list.
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets Actor list.
     *
     * @return actor list.
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

}
