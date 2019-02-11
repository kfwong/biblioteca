package com.twu.biblioteca;

public class Book extends Item {

    private String author;
    private int year;

    public Book(String title, String author, int year) {
        super(title);
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

}
