package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.User;
import com.epam.training.ticketservice.core.repository.CoreRepository;
import com.epam.training.ticketservice.core.repository.UserRepository;
import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CoreServiceImpl<User> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(CoreRepository<User> entityRepository, UserRepository userRepository) {
        super(entityRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
