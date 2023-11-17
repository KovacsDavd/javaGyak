package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Movie;
import com.epam.training.ticketservice.core.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MovieCommandTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieCommand movieCommand;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_create_movie() {
        when(movieService.findByTitle(anyString())).thenReturn(null);

        String res = movieCommand.createMovie("Title", "Genre", 120);

        assertEquals("Successful addition", res);
    }

    @Test
    public void test_create_movie_exists() {
        var movie = new Movie();
        movie.setTitle("Title");
        when(movieService.findByTitle(anyString())).thenReturn(movie);

        String res = movieCommand.createMovie("Title", "Genre", 120);

        assertEquals("Movie is already exists", res);
    }

    @Test
    public void test_update_movie() {
        when(movieService.findByTitle(anyString())).thenReturn(new Movie());

        String res = movieCommand.updateMovie("Title", "NewGenre", 150);

        assertEquals("Successful update", res);
    }

    @Test
    public void test_update_movie_not_exists() {
        when(movieService.findByTitle(anyString())).thenReturn(null);

        String res = movieCommand.updateMovie("Title", "NewGenre", 150);

        assertEquals("Movie is not exists", res);
    }

    @Test
    public void test_delete_movie() {
        when(movieService.findByTitle(anyString())).thenReturn(new Movie());

        String result = movieCommand.deleteMovie("Title");

        assertEquals("Successful delete", result);
    }

    @Test
    public void test_delete_movie_not_exists() {
        when(movieService.findByTitle(anyString())).thenReturn(null);

        String result = movieCommand.deleteMovie("Title");

        assertEquals("Movie is not exists", result);
    }

    @Test
    public void test_list_movies_no_movies() {
        when(movieService.findAll()).thenReturn(Collections.emptyList());

        String result = movieCommand.listMovie();

        assertEquals("There are no movies at the moment", result);
    }

    @Test
    public void test_list_movies() {
        var movie = new Movie();
        movie.setTitle("Title");
        movie.setLength(1);
        movie.setGenre("gen");

        when(movieService.findAll()).thenReturn(List.of(movie));

        String result = movieCommand.listMovie();

        assertEquals("Title (gen, 1 minutes)", result);
    }
}
