package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LibraryTest {
    private Book book1 = new Book("book1", "author1", 2000);
    private Book book2 = new Book("book2", "author2", 1998);
    private Book book3 = new Book("book3", "author3", 1987);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Library library;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        this.library = new Library() {
            @Override
            public Book[] getBookSource() {
                return new Book[]{book1, book2};
            }
        };
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_instantiate_with_two_books(){
        assertEquals(2, library.availableBooks().length);



        assertEquals("book1", library.availableBooks()[0].getTitle());
        assertEquals("book2", library.availableBooks()[1].getTitle());
    }

    @Test
    public void should_checkout_book_successfully_if_available_in_record(){
        assertTrue(library.isAvailable(book1));

        library.checkout(book1);

        assertFalse(library.isAvailable(book1));

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());

    }

    @Test
    public void should_checkout_book_unsucessfully_if_unavailable_in_record(){
        assertFalse(library.isAvailable(book3));

        library.checkout(book3);

        assertFalse(library.isAvailable(book3));

        assertEquals("Sorry, that book is unavailable", outContent.toString().trim());
    }


    @Test
    public void should_checkin_book_successfully_if_unavailable_in_record(){
        assertFalse(library.isAvailable(book3));

        library.checkin(book3);

        assertTrue(library.isAvailable(book3));
    }
}
