package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.Movie;
import com.epam.training.ticketservice.core.repository.MovieRepository;
import com.epam.training.ticketservice.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository MovieRepository) {
        this.movieRepository = MovieRepository;
    }

    @Override
    public void save(Movie Movie) {
        movieRepository.save(Movie);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
