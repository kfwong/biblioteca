package com.twu.biblioteca;

import java.util.Arrays;

public class Book extends Item {

    private String author;
    private int year;

    public Book(String title, String author, int year) {
        super(title);
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String displayFormat() {
        final String BOOKS_FORMAT = "%-40s%-20s%-20d";
        return String.format(BOOKS_FORMAT, title, author, year);
    }
}
