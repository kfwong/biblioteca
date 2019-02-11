package com.twu.biblioteca.library;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Movie;

import java.util.stream.Stream;

public class BibliotecaLibrary extends Library {
    final static Book[] BOOKS = {
            new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", 2007),
            new Book("Fifty Shades of Grey", "E.L. James", 2011)};

    final static Movie[] MOVIES = {
            new Movie("Frozen", 2013, "Jennifer Lee, Chris Buck", 7.5),
            new Movie("Wonder Woman", 2017, "Patty Jenkins", 7.5),
            new Movie("Captain Marvel", 2019, "Anna Boden, Ryan Fleck", -1)
    };

    @Override
    public Item[] getItemSource() {
        return Stream.of(BOOKS, MOVIES)
                .flatMap(Stream::of)
                .toArray(Item[]::new);
    }
}
