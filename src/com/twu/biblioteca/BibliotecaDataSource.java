package com.twu.biblioteca;

public class BibliotecaDataSource {

    private final Book[] books = {
            new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007),
            new Book("Fifty Shades of Grey", "E.L. James", 2011)};

    public Book[] getBooks() {
        return books;
    }
}
