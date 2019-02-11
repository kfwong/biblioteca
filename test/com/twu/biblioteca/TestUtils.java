package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    private static Book book1 = new Book("book1", "author1", 2000);
    private static Book book2 = new Book("book2", "author2", 1998);

    private static Movie movie1 = new Movie("movie1", 1991, "director1", 5.6);
    private static Movie movie2 = new Movie("movie2", 1995, "director2", -1);

    public static String readTestResourceAsString(String filename) throws Exception {
        URI file = TestUtils.class.getClassLoader().getResource(filename).toURI();

        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }

    public static Library mockBookLibrary(){

        return new Library() {
            @Override
            public Book[] getItemSource() {
                return new Book[]{book1, book2};
            }
        };
    }

    public static Library mockMovieLibrary(){

        return new Library() {
            @Override
            public Movie[] getItemSource() {
                return new Movie[]{movie1, movie2};
            }
        };
    }

    public static Library mockMixLibrary() {
        return new Library() {
            @Override
            public Item[] getItemSource() {
                return new Item[]{book2, movie1, movie2, book1};
            }
        };
    }
}
