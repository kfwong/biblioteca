package com.twu.biblioteca.library;

import com.twu.biblioteca.Book;

public class BibliotecaLibrary extends Library {
    final static Book[] BOOKS = {
            new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007),
            new Book("Fifty Shades of Grey", "E.L. James", 2011)};

    @Override
    public Book[] getBookSource() {
        return BOOKS;
    }
}
