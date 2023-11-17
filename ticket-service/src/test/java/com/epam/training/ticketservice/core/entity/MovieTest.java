package com.epam.training.ticketservice.core.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie();
    }

    @Test
    public void test_id() {
        movie.setId(1L);

        assertEquals(Long.valueOf(1), movie.getId());
    }

    @Test
    public void test_title() {
        movie.setTitle("1L");

        assertEquals("1L", movie.getTitle());
    }

    @Test
    public void test_genre() {
        movie.setGenre("1L");

        assertEquals("1L", movie.getGenre());
    }

    @Test
    public void test_length() {
        movie.setLength(1);

        assertEquals(1, movie.getLength());
    }

    @Test
    public void test_to_string() {
        var movie2 = new Movie("title", "gen", 1);
        var exp = "title (gen, 1 minutes)";
        assertEquals(exp, movie2.toString());
    }
}
