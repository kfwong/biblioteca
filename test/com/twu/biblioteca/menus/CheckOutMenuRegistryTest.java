package com.twu.biblioteca.menus;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.library.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckOutMenuRegistryTest {

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
            public Book[] getItemSource() {
                return new Book[]{book1, book2};
            }
        };
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void should_allow_checkout_existing_book(){
        assertTrue(library.isAvailable(book1));

        new CheckOutMenu().checkOut(library, "book1");

        assertEquals("Thank you! Enjoy the book", outContent.toString().trim());
    }

    @Test
    public void should_disallow_checkout_non_existing_book(){
        assertFalse(library.isAvailable(book3));

        new CheckOutMenu().checkOut(library, "book3");

        assertEquals("Sorry, that item is unavailable", outContent.toString().trim());
    }

}
