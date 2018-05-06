package MovieDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MovieDatabase {
    ArrayList<Movie> movieList;
    ArrayList<Actor> actorList;

    MovieDatabase() {
        movieList = new ArrayList<Movie>();
        actorList =  new ArrayList<Actor>();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    void addMovie(String name, String[] actors) {
        if (!getMovieList().contains(new Movie(name))) {
            Movie newMovie = new Movie(name);
            newMovie.setName(name);

            ArrayList<Actor> actorsMovieList = new ArrayList<>();
            for (String actor : actors) {
                actorsMovieList.add(new Actor(actor));
            }
            newMovie.setActors(actorsMovieList);
            getMovieList().add(newMovie);
        } else {
            Movie existingMovie = getMovieList().get(getMovieList().indexOf(new Movie(name)));
            ArrayList<Actor> existingActors = existingMovie.getActors();

            for (String actor : actors) {
                if (!existingMovie.getActors().contains(new Actor(actor))) {
                    existingActors.add(new Actor(actor));
                }
            }
            existingMovie.setActors(existingActors);
        }

        for (String actor : actors) {
            if (!getActorList().contains(new Actor(actor))) {
                Actor newActor = new Actor(actor);
                ArrayList<Movie> actorMoviesList = new ArrayList<>();
                actorMoviesList.add(new Movie(name));
                newActor.setMovies(actorMoviesList);
                getActorList().add(newActor);
            } else {
                Actor existingActor = getActorList().get(getActorList().indexOf(new Actor(actor)));
                ArrayList<Movie> existingMovies = existingActor.getMovies();

                if (!existingActor.getMovies().contains(new Movie(name))) {
                    existingMovies.add(new Movie(name));
                }
                existingActor.setMovies(existingMovies);

            }
        }
    }

    /**
     * Add a rating for this movie.
     * @param name of the movie
     * @param rating of the movie
     */
    void addRating(String name, double rating) {
        for (Movie movie: getMovieList()) {
            if (movie.getName().contains(name)) {
                movie.setRating(rating);
                break;
            }
        }
    }

    /**
     * Updates the current rating of a movie with this new rating.
     * @param name of the movie.
     * @param newRating of the movie.
     */
    void updateRating(String name, double newRating) {
        movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
    }

    String getBestActor() {
        double maxActorRating = 0;
        String maxActorName = null;
        for (Actor actor :
                getActorList())
            if (actor.getActorRating(getMovieList()) >= maxActorRating) {
                maxActorRating = actor.getActorRating(getMovieList());
                maxActorName = actor.getName();
            }
        return maxActorName;
    }

    String getBestMovie() {
        double maxRatingMovie = 0;
        String maxRatingMovieName = null;
        for (Movie movie :
                getMovieList()) {
            if (movie.getRating() >= maxRatingMovie) {
                maxRatingMovie = movie.getRating();
                maxRatingMovieName = movie.getName();
            }
        }
        return maxRatingMovieName;
    }

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        String fileName = "./resources/movies.txt";
        String line;
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] actorMovies = line.split(",", -1);
                for (int i = 1; i < actorMovies.length; i++) {
                    movieDatabase.addMovie(actorMovies[i], new String[]{ actorMovies[0] });
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
        }

        String ratingsFile = "./resources/ratings.txt";
        String lineRating;
        try {
            FileReader fileReader =
                    new FileReader(ratingsFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.readLine() != null) {
                while ((lineRating = bufferedReader.readLine()) != null) {
                    String[] movieRating = lineRating.split("\t", -1);
                    for (int i = 1; i < movieRating.length; i++) {
                        movieDatabase.addRating(movieRating[0], Double.parseDouble(movieRating[1]));
                    }
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + ratingsFile + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + ratingsFile + "'");
        }

        System.out.println(movieDatabase.getBestActor());
        System.out.println(movieDatabase.getBestMovie());
    }
}
