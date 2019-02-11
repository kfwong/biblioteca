package com.twu.biblioteca;


import com.twu.biblioteca.auth.BibliotecaMembership;
import com.twu.biblioteca.auth.Membership;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.menus.ListAllItemsMenu;
import com.twu.biblioteca.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.TestUtils.readTestResourceAsString;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private final Library bookLibrary = TestUtils.mockBookLibrary();
    private Item book1 = bookLibrary.getItemSource()[0];

    private final Library movieLibrary = TestUtils.mockMovieLibrary();
    private Item movie1 = movieLibrary.getItemSource()[0];

    private final Library mixLibrary = TestUtils.mockMixLibrary();

    private BibliotecaApp bibliotecaApp;

    private Membership membership = new BibliotecaMembership();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        bibliotecaApp = new BibliotecaApp(mixLibrary, membership);

    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void should_display_welcome_message() throws Exception {

        String expected = readTestResourceAsString("should_display_welcome_message.txt");

        bibliotecaApp.displayWelcomeMessage();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_display_menu() throws Exception{

        String expected = readTestResourceAsString("should_display_menu.txt");

        bibliotecaApp.displayMenu();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_not_display_invalid_entry_in_menu(){

        bibliotecaApp.displayMenu();

        assertFalse(outContent.toString().contains("Invalid"));
    }

    @Test
    public void should_display_invalid_message_when_select_invalid_menu(){
        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(999);

        assertEquals("Please select a valid option!", outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_books() throws Exception {
        bibliotecaApp = new BibliotecaApp(bookLibrary, membership);

        String expected = readTestResourceAsString("should_display_list_of_books.txt");

        new ListAllItemsMenu().execute(bibliotecaApp);

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_books_when_select_menu_one() throws Exception{
        bibliotecaApp = new BibliotecaApp(bookLibrary, membership);

        String expected = readTestResourceAsString("should_display_list_of_books_when_select_menu_one.txt");

        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(1);

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_display_only_available_books() throws Exception{
        bibliotecaApp = new BibliotecaApp(bookLibrary, membership);

        String expected = readTestResourceAsString("should_display_only_available_books.txt");

        assertTrue(bookLibrary.isAvailable(book1));

        bookLibrary.checkOut(book1);

        outContent.reset();

        assertFalse(bookLibrary.isAvailable(book1));

        new ListAllItemsMenu().execute(bibliotecaApp);

        assertEquals(expected, outContent.toString().trim());

    }

    @Test
    public void should_display_list_of_movies() throws Exception {
        bibliotecaApp = new BibliotecaApp(movieLibrary, membership);

        String expected = readTestResourceAsString("should_display_list_of_movies.txt");

        new ListAllItemsMenu().execute(bibliotecaApp);

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_display_list_of_movies_when_select_menu_one() throws Exception{
        bibliotecaApp = new BibliotecaApp(movieLibrary, membership);

        String expected = readTestResourceAsString("should_display_list_of_movies_when_select_menu_one.txt");

        bibliotecaApp.displayMenu();

        outContent.reset();

        bibliotecaApp.selectMenu(1);

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_display_only_available_movies() throws Exception{
        bibliotecaApp = new BibliotecaApp(movieLibrary, membership);

        String expected = readTestResourceAsString("should_display_only_available_movies.txt");

        assertTrue(movieLibrary.isAvailable(movie1));

        movieLibrary.checkOut(movie1);

        outContent.reset();

        assertFalse(movieLibrary.isAvailable(movie1));

        new ListAllItemsMenu().execute(bibliotecaApp);

        assertEquals(expected, outContent.toString().trim());

    }

    @Test
    public void should_login_successfully(){
        bibliotecaApp.login("000-0000", "000");

        assertEquals("Welcome! You are logged in", outContent.toString().trim());
    }
}
