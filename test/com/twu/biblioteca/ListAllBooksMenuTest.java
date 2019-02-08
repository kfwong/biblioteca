package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListAllBooksMenuTest {

    private final ListAllBooksMenu listAllBooksMenu = new ListAllBooksMenu();
    private final BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_display_tabulate_header(){
        assertEquals("Title                                   Author              Year                ", listAllBooksMenu.tabulateHeader());
    }

    @Test
    public void should_tabulate_fields_with_tabs(){

        assertEquals("Fifty Shades of Grey                    E.L. James          2011                \n" +
                "Harry Potter and the Deathly Hallows    J.K. Rowling        2007                ", listAllBooksMenu.tabulateBooks(bibliotecaLibrary.availableBooks()));
    }

    @Test
    public void should_display_list_of_books() {
        listAllBooksMenu.displayListOfBooks(bibliotecaLibrary.availableBooks());

        assertEquals("Title                                   Author              Year                \n" +
                "Fifty Shades of Grey                    E.L. James          2011                \n" +
                "Harry Potter and the Deathly Hallows    J.K. Rowling        2007", outContent.toString().trim());
    }
}
