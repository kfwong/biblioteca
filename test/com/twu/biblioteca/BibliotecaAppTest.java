package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private final BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaDataSource());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
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
                "Harry Potter and the Deathly Hallows    J.K. Rowling        2007                \n" +
                "Fifty Shades of Grey                    E.L. James          2011", outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_books_when_select_menu_one(){
        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(1);

        assertEquals("Title                                   Author              Year                \n" +
                "Harry Potter and the Deathly Hallows    J.K. Rowling        2007                \n" +
                "Fifty Shades of Grey                    E.L. James          2011", outContent.toString().trim());
    }

    @Test
    public void should_display_invalid_message_when_select_invalid_menu(){
        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(999);

        assertEquals("Invalid menu. Try again?", outContent.toString().trim());
    }
}
