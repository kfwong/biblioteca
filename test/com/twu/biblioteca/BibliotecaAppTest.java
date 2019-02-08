package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Book book1 = new Book("book1", "author1", 2000);
    private Book book2 = new Book("book2", "author2", 1998);
    private final Library library = new Library() {
        @Override
        public Book[] getBookSource() {
            return new Book[]{book1, book2};
        }
    };

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        bibliotecaApp = new BibliotecaApp(library);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void should_display_welcome_message() {

        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", outContent.toString().trim());
    }

    @Test
    @Ignore
    public void should_display_menu(){
        bibliotecaApp.displayMenu();

        assertEquals("1. List all books", outContent.toString().trim());
    }

    @Test
    @Ignore
    public void should_not_display_invalid_menu(){

    }

    @Test
    public void should_display_list_of_books() {
        new ListAllBooksMenu().execute(bibliotecaApp);

        assertEquals("Title                                   Author              Year                \n" +
                "book1                                   author1             2000                \n" +
                "book2                                   author2             1998", outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_books_when_select_menu_one(){
        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(1);

        assertEquals("Title                                   Author              Year                \n" +
                "book1                                   author1             2000                \n" +
                "book2                                   author2             1998", outContent.toString().trim());
    }

    @Test
    public void should_display_invalid_message_when_select_invalid_menu(){
        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(999);

        assertEquals("Please select a valid option!", outContent.toString().trim());
    }

    @Test
    public void should_display_only_available_books(){
        assertTrue(library.isAvailable(book1));

        library.checkout(book1);

        outContent.reset();

        assertFalse(library.isAvailable(book1));

        new ListAllBooksMenu().execute(bibliotecaApp);

        assertEquals("Title                                   Author              Year                \n" +
                "book2                                   author2             1998", outContent.toString().trim());

    }
}
