package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static String readTestResourceAsString(String filename) throws Exception {
        URI file = TestUtils.class.getClassLoader().getResource(filename).toURI();

        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }

    public static Library mockLibrary(){
        Book book1 = new Book("book1", "author1", 2000);
        Book book2 = new Book("book2", "author2", 1998);

        return new Library() {
            @Override
            public Book[] getItemSource() {
                return new Book[]{book1, book2};
            }
        };
    }
}
