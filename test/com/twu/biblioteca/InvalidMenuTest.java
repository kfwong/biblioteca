package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidMenuTest {
    private final InvalidMenu invalidMenu = new InvalidMenu();
    private final BibliotecaApp bibliotecaApp = new BibliotecaApp(new BibliotecaDataSource());

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

        assertEquals("Invalid menu. Try again?", outContent.toString().trim());
    }
}
