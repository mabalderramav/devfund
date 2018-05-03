package org.minions.devfund.sergio.movie_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MovieDatabase {
    ArrayList<Movie> movieList;
    ArrayList<Actor> actorList;
    Map<String, Integer> rankingList;

    public MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
        rankingList = new HashMap<>();
        loadDate();
    }

    public void addMovie(String name, String[] actors) {
        Movie movie = new Movie(name);
        movie.setActors(actorList);
        movieList.add(movie);
    }

    public void addRating(String name, int rating) {
        rankingList.put(name, rating);
    }

    public void updateRating(String name, int newRating) {
        if (rankingList.containsKey(name))
            rankingList.replace(name, newRating);
    }

    public String getBestActor() {
        return "to do";
    }

    public String getBestMovie() {
        String bestMovie = "";
        Integer maxValueInMap = (Collections.max(rankingList.values()));
        System.out.println("**********all these movies has the same rankings***********");
        for (Map.Entry<String, Integer> entry : rankingList.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                bestMovie = entry.getKey();

                System.out.println(bestMovie);
            }
        }
        System.out.println("****************************************");
        return bestMovie;
    }

    private void loadDate() {
        File f = new File("D:\\ratings.txt");
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            entrada.readLine();
            while (entrada.ready()) {
                linea = entrada.readLine();
                int ranking = Integer.parseInt(linea.substring(linea.length() - 3, linea.length()).trim());
                String name = linea.substring(0, linea.length() - 3);
                addRating(name, ranking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.close();
            } catch (IOException e1) {
            }
        }
    }

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        System.out.println("the best movies is: " + movieDatabase.getBestMovie());
    }
}
