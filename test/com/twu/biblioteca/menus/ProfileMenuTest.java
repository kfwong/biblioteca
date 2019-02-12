package com.twu.biblioteca.menus;

import com.twu.biblioteca.TestUtils;
import com.twu.biblioteca.auth.Member;
import com.twu.biblioteca.auth.MemberType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ProfileMenuTest {

    private Member librarian = new Member("111-1111", "111", MemberType.LIBRARIAN, "John Snow", "11111111", "johnsnow@example.com");
    private final ProfileMenu profileMenu = new ProfileMenu();

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
    public void should_display_profile_in_two_columns() throws Exception{
        String expected = TestUtils.readTestResourceAsString("should_display_profile_in_two_columns.txt");
        profileMenu.displayProfile(librarian);

        assertEquals(expected, outContent.toString().trim());
    }
}
