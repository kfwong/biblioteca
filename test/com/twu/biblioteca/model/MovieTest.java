package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MovieTest {

    Movie movie = new Movie("movie1", 2001, "director1", 5.5);

    @Test
    public void should_instantiate_valid_movie_instance(){

        assertNotNull(movie);

    }

    @Test
    public void should_be_able_to_read_all_field(){

        assertEquals("movie1", movie.getTitle());
        assertEquals(2001, movie.getYear());
        assertEquals("director1", movie.getDirector());
        assertEquals(5.5, movie.getRating(), 0);
    }
}
