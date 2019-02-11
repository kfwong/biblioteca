package com.twu.biblioteca;

public class Movie extends Item {

    private int year;

    public Movie(String title, int year){
        super(title);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String displayFormat() {
        return null;
    }
}
