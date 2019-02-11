package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieTest {

    Movie movie = new Movie("movie1", 2001);

    @Test
    public void should_instantiate_valid_movie_instance(){

        assertNotNull(movie);

    }

    @Test
    public void should_be_able_to_read_all_field(){

        assertEquals("movie1", movie.getTitle());
        assertEquals(2001, movie.getYear());
    }
}
