package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.library.BibliotecaLibrary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidMenuRegistryTest {
    private final InvalidMenu invalidMenu = new InvalidMenu();
    private final BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaLibrary());

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
    public void should_display_invalid_message(){
        invalidMenu.execute(bibliotecaApp);

        assertEquals("Please select a valid option!", outContent.toString().trim());
    }
}
