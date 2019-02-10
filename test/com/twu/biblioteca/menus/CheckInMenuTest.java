package com.twu.biblioteca;

import com.twu.biblioteca.menus.CheckInMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CheckInMenuTest {


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
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void should_allow_return_valid_book() {
        assertTrue(library.isAvailable(book1));

        library.checkOut(book1);

        outContent.reset();

        assertFalse(library.isAvailable(book1));

        new CheckInMenu().checkIn(library, "book1");

        assertTrue(library.isAvailable(book1));

        assertEquals("Thank you for returning the book", outContent.toString().trim());
    }

    @Test
    public void should_not_allow_return_invalid_book(){
        assertFalse(library.isAvailable(book3));
        assertFalse(Arrays.stream(library.getBookSource()).anyMatch(b -> b.getTitle().equals("book3")));

        new CheckInMenu().checkIn(library, "book3");

        assertFalse(library.isAvailable(book3));

        assertEquals("This is not a valid book to return", outContent.toString().trim());
    }

}
