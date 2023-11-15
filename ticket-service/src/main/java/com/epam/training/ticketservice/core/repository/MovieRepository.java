package com.epam.training.ticketservice.core.repository;

import com.epam.training.ticketservice.core.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CoreRepository<Movie> {
    Movie findByTitle(String title);
}
