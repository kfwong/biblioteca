package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
public class BookTest {

    @Test
    public void should_instantiate_valid_book_instance(){
        Book book = new Book("title", "author", 2018);

        assertNotNull(book);

    }
}
