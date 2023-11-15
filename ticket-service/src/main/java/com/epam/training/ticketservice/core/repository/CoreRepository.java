package com.epam.training.ticketservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface CoreRepository<T> extends JpaRepository<T, Long> {
}
