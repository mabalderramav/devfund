package MovieDatabase;

import java.util.ArrayList;

public class Movie {
    String name;
    ArrayList<Actor> actors;
    double rating;

    public Movie(String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<>();
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

    public boolean equals(Object object) {
        return ((Movie) object).getName().equals(name);
    }
}
