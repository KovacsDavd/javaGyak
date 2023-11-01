package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.User;
import com.epam.training.ticketservice.core.repository.UserRepository;
import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
