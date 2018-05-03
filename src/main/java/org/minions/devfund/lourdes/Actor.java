package org.minions.devfund.lourdes;

import java.util.ArrayList;

public class Actor {
    private String name;

    private ArrayList<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<Movie>();
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }
    public double averageRating(){
        double average = 0;
        for (Movie movie: movies) {
            average+=movie.getRating();
        }
        return average/movies.size();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
