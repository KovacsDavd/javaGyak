package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();
}
