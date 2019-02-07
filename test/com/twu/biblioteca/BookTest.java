package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
public class BookTest {
    Book book = new Book("title", "author", 2018);

    @Test
    public void should_instantiate_valid_book_instance(){

        assertNotNull(book);

    }

    @Test
    public void should_be_able_to_read_all_fields(){

        assertEquals("title", book.getTitle());
        assertEquals("author", book.getAuthor());
        assertEquals(2018, book.getYear());
    }
}
