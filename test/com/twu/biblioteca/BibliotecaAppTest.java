package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void should_display_welcome_message() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.displayWelcomeMessage();
    }
}
