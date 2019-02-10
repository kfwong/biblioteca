package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

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

        library.checkOut(book1);

        assertFalse(library.isAvailable(book1));

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());

    }

    @Test
    public void should_checkout_book_unsucessfully_if_unavailable_in_record(){
        assertFalse(library.isAvailable(book3));

        library.checkOut(book3);

        assertFalse(library.isAvailable(book3));

        assertEquals("Sorry, that book is unavailable", outContent.toString().trim());
    }


    @Test
    public void should_checkin_book_successfully_if_unavailable_in_record(){
        assertFalse(library.isAvailable(book3));

        library.checkIn(book3);

        assertTrue(library.isAvailable(book3));
    }

    @Test
    public void should_return_existing_book(){
        assertTrue(library.isAvailable(book1));

        Optional<Book> book = library.findAvailableBookByTitle("book1");

        assertTrue(book.isPresent());
        assertEquals(book.get(), book1);
    }

    @Test
    public void should_return_null_for_non_existing_book(){
        assertFalse(library.isAvailable(book3));

        Optional<Book> book = library.findAvailableBookByTitle("book3");

        assertFalse(book.isPresent());
    }
}
