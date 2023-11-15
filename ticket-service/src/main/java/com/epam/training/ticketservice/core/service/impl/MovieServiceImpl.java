package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.Movie;
import com.epam.training.ticketservice.core.repository.CoreRepository;
import com.epam.training.ticketservice.core.repository.MovieRepository;
import com.epam.training.ticketservice.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends CoreServiceImpl<Movie> implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(CoreRepository<Movie> entityRepository, MovieRepository movieRepository) {
        super(entityRepository);
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
