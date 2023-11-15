package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.Movie;

public interface MovieService extends CoreService<Movie> {

    Movie findByTitle(String title);
}
