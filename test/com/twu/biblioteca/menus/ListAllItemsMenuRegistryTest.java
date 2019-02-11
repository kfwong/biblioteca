package com.twu.biblioteca.menus;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.TestUtils.readTestResourceAsString;
import static org.junit.Assert.assertEquals;

public class ListAllItemsMenuRegistryTest {

    private final ListAllItemsMenu listAllItemsMenu = new ListAllItemsMenu();

    private final Library library = TestUtils.mockLibrary();

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
        assertEquals(expected, listAllItemsMenu.tabulateHeader());
    }

    @Test
    public void should_tabulate_fields_with_tabs() throws Exception{
        String expected = readTestResourceAsString("should_tabulate_fields_with_tabs.txt");
        assertEquals(expected, listAllItemsMenu.tabulateBooks(library.availableItems()));
    }

    @Test
    public void should_display_list_of_books() throws Exception {
        String expected = readTestResourceAsString("should_display_list_of_books.txt");
        listAllItemsMenu.displayListOfBooks(library.availableItems());

        assertEquals(expected, outContent.toString().trim());
    }
}
