package com.epam.training.ticketservice.core.service;

import java.util.List;

public interface CoreService<T> {
    void save(T entity);

    void delete(T entity);

    List<T> findAll();
}
