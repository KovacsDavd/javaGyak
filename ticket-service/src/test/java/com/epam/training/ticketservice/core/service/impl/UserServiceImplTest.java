package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_find_by_username_and_password() {
        userService.findByUsernameAndPassword("a", "a");
        verify(userRepository, times(1))
                .findByUsernameAndPassword("a", "a");
    }
}
