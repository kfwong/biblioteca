package com.twu.biblioteca;

public class Movie extends Item {

    private int year;

    public Movie(String title, int year){
        super(title);
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
