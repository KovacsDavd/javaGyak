package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.User;
import com.epam.training.ticketservice.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserCommandTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserCommand userCommand;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_login() {
        when(userService.findByUsernameAndPassword(anyString(), anyString())).thenReturn(new User());

        String res = userCommand.login("username", "password");

        assertEquals("Successful login", res);
    }

    @Test
    public void test_login_fail() {
        when(userService.findByUsernameAndPassword(anyString(), anyString())).thenReturn(null);

        String res = userCommand.login("username", "password");

        assertEquals("Login failed due to incorrect credentials", res);
    }

    @Test
    public void test_sign_out() {
        userCommand.setLogged(true);

        userCommand.signOut();

        assertFalse(userCommand.getLogged());
    }

    @Test
    public void test_describe() {
        User user = new User();
        user.setAdmin(true);
        user.setUsername("asd");
        userCommand.setLogged(true);

        when(userService.findAll()).thenReturn(List.of(user));

        String res = userCommand.describe();

        assertEquals("Signed in with privileged account 'asd'", res);
    }

    @Test
    public void test_describe_not_logged() {
        User user = new User();
        user.setAdmin(true);
        user.setUsername("asd");

        when(userService.findAll()).thenReturn(List.of(user));

        String res = userCommand.describe();

        assertEquals("You are not signed in", res);
    }
}
