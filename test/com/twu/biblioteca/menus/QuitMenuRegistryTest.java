package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.library.BibliotecaLibrary;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QuitMenuRegistryTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final QuitMenu quitMenu = new QuitMenu();
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
    public void should_display_exit_message_and_exit(){
        exit.expectSystemExitWithStatus(0);

        quitMenu.execute(bibliotecaApp);
    }

}
