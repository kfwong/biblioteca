package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaDataSource());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_display_welcome_message() {

        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", outContent.toString().trim());
    }

    @Test
    public void should_display_menu(){
        bibliotecaApp.displayMenu();

        assertEquals("1. List all books", outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_books() {
        bibliotecaApp.selectMenu(new ListAllBooksMenu());

        assertEquals("Title                                   Author              Year                \n" +
                "Harry Potter and the Deathly Hallows    J.K. Rowling        2007                \n" +
                "Fifty Shades of Grey                    E.L. James          2011", outContent.toString().trim());
    }

    @Test
    public void should_prompt_user_for_menu_choice(){
        bibliotecaApp.promptMenuChoice();

        assertEquals("Your choice: ", outContent.toString());
    }
}
