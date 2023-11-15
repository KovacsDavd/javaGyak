package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.repository.CoreRepository;
import com.epam.training.ticketservice.core.service.CoreService;

import java.util.List;

public abstract class CoreServiceImpl<T> implements CoreService<T> {
    private final CoreRepository<T> entityRepository;

    public CoreServiceImpl(CoreRepository<T> entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void save(T entity) {
        entityRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        entityRepository.delete(entity);
    }

    @Override
    public List<T> findAll() {
        return entityRepository.findAll();
    }
}
