package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.User;
import com.epam.training.ticketservice.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.shell.Availability;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class CommandAvailabilityTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private CommandAvailability commandAvailability;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_is_logged() {
        commandAvailability.setLogged(true);

        var res = commandAvailability.isLogged().isAvailable();

        assertEquals(Availability.available().isAvailable(), res);
        assertTrue(commandAvailability.getLogged());
    }

    @Test
    public void test_is_not_logged() {
        commandAvailability.setLogged(true);

        var res = commandAvailability.isNotLogged().isAvailable();

        assertEquals(Availability.unavailable("").isAvailable(), res);
    }

    @Test
    public void test_is_admin() {
        User user = new User();
        user.setAdmin(true);
        commandAvailability.setLogged(true);

        when(userService.findAll()).thenReturn(List.of(user));

        var res = commandAvailability.isAdmin().isAvailable();
        assertEquals(Availability.available().isAvailable(), res);
    }
}
