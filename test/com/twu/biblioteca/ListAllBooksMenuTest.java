package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListAllBooksMenuTest extends BaseTest{

    private final ListAllBooksMenu listAllBooksMenu = new ListAllBooksMenu();

    private Book book1 = new Book("book1", "author1", 2000);
    private Book book2 = new Book("book2", "author2", 1998);
    private final Library library = new Library() {
        @Override
        public Book[] getBookSource() {
            return new Book[]{book1, book2};
        }
    };

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
    public void should_display_tabulate_header() throws Exception{
        String expected = readTestResourceAsString("should_display_tabulate_header.txt");
        assertEquals(expected, listAllBooksMenu.tabulateHeader());
    }

    @Test
    public void should_tabulate_fields_with_tabs() throws Exception{
        String expected = readTestResourceAsString("should_tabulate_fields_with_tabs.txt");
        assertEquals(expected, listAllBooksMenu.tabulateBooks(library.availableBooks()));
    }

    @Test
    public void should_display_list_of_books() throws Exception {
        String expected = readTestResourceAsString("should_display_list_of_books.txt");
        listAllBooksMenu.displayListOfBooks(library.availableBooks());

        assertEquals(expected, outContent.toString().trim());
    }
}
