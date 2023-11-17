package com.epam.training.ticketservice.core.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    public void init() {
        user = new User();
    }

    @Test
    public void test_id() {
        user.setId(1L);

        assertEquals(Long.valueOf(1), user.getId());
    }

    @Test
    public void test_row_number() {
        user.setAdmin(true);

        assertTrue(user.isAdmin());
    }

    @Test
    public void test_column_number() {
        user.setPassword("asd");

        assertEquals("asd", user.getPassword());
    }

    @Test
    public void test_name() {
        user.setUsername("1");

        assertEquals("1", user.getUsername());
    }
}
