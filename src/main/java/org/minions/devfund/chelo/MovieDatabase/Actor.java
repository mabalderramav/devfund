package MovieDatabase;

import java.util.ArrayList;

public class Actor {
    String name;
    ArrayList<Movie> movies;

    public Actor(String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public boolean equals(Object object) {
        return ((Actor) object).getName().equals(name);
    }

    public double getActorRating(ArrayList<Movie> Movies) {
        double ratingMovies = 0;
        for (Movie movie : Movies) {
            ratingMovies += movie.getRating();
        }
        return ratingMovies / Movies.size();
    }
}
