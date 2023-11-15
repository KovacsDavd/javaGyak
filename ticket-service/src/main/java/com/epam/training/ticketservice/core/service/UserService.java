package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.User;

public interface UserService extends CoreService<User> {
    User findByUsernameAndPassword(String username, String password);
}
