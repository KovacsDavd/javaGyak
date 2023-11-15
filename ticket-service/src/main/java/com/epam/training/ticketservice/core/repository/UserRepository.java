package com.epam.training.ticketservice.core.repository;

import com.epam.training.ticketservice.core.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CoreRepository<User> {
    User findByUsernameAndPassword(String username, String password);
}
