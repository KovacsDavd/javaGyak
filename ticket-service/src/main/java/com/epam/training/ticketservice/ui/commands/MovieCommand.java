package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Movie;
import com.epam.training.ticketservice.core.service.MovieService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class MovieCommand extends CommandAvailability {

    private final MovieService movieService;

    public MovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @ShellMethod(key = "create movie", value = "Create movie")
    @ShellMethodAvailability(value = "isAdmin")
    public String createMovie(String title, String genre, int length) {
        if (movieService.findByTitle(title) == null) {
            movieService.save(new Movie(title, genre, length));
            return "Successful addition";
        }
        return "Movie is already exists";
    }

    @ShellMethod(key = "update movie", value = "Update movie")
    @ShellMethodAvailability(value = "isAdmin")
    public String updateMovie(String title, String genre, int length) {
        var movie = movieService.findByTitle(title);
        if (movie != null) {
            movie.setGenre(genre);
            movie.setLength(length);
            movieService.save(movie);
            return "Successful update";
        }
        return "Movie is not exists";
    }

    @ShellMethod(key = "delete movie", value = "Delete movie")
    @ShellMethodAvailability(value = "isAdmin")
    public String deleteMovie(String title) {
        var movie = movieService.findByTitle(title);
        if (movie != null) {
            movieService.delete(movie);
            return "Successful delete";
        }
        return "Movie is not exists";
    }

    @ShellMethod(key = "list movies", value = "List movies")
    public String listMovie() {
        var movies = movieService.findAll();
        StringBuilder res = new StringBuilder();
        if (movies.isEmpty()) {
            return "There are no movies at the moment";
        }
        for (var movie : movies) {
            res.append(movie.toString());
        }
        return res.toString();
    }
}
