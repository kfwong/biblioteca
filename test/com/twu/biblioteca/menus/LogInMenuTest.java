package com.twu.biblioteca.menus;

import com.twu.biblioteca.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LogInMenuTest {

    private Scanner scanner;
    private final LogInMenu logInMenu = new LogInMenu();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(new ByteArrayInputStream("000-0000".getBytes()));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        scanner.close();
    }

    @Test
    public void should_prompt_user_for_library_number() throws Exception{
        String expected = TestUtils.readTestResourceAsString("should_prompt_user_for_library_number.txt");

        logInMenu.promptUserLibraryNumber(scanner);

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void should_prompt_user_for_password() {

        logInMenu.promptUserPassword(scanner);

        assertEquals("Password:", outContent.toString().trim());
    }
}
