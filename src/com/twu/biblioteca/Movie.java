package com.twu.biblioteca;

public class Movie extends Item {

    private int year;
    private String director;
    private double rating;

    public Movie(String title, int year, String director, double rating){
        super(title);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String displayFormat() {
        final String MOVIE_FORMAT = "%-40s%-20s%-20d%-40s%-20s";
        return String.format(MOVIE_FORMAT, title, "-", year, director, rating == -1? "unrated": rating);
    }
}
