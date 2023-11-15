package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.Movie;

import java.util.List;

public interface MovieService {
    void save(Movie Movie);

    void delete(Movie movie);

    List<Movie> findAll();

    Movie findByTitle(String title);
}
