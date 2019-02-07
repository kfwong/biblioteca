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
    private final BibliotecaApp bibliotecaApp = new BibliotecaApp();

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
    public void should_display_list_of_books() {
        bibliotecaApp.displayListOfBooks();

        assertEquals("Harry Potter and the Deathly Hallows\nFifty Shades of Grey", outContent.toString().trim());
    }

    @Test
    public void should_tabulate_fields_with_tabs(){

        assertEquals("Harry Potter and the Deathly Hallows\tJ.K. Rowling\t2007\nFifty Shades of Grey\tE.L. James\t2011", bibliotecaApp.tabulateBooks());
    }
}
