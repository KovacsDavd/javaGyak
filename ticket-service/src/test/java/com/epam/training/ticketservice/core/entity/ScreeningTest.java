package com.epam.training.ticketservice.core.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreeningTest {
    private Screening screening;

    @BeforeEach
    public void init() {
        screening = new Screening();
    }

    @Test
    public void test_id() {
        screening.setId(1L);

        assertEquals(Long.valueOf(1), screening.getId());
    }

    @Test
    public void test_title() {
        screening.setTitle("1");

        assertEquals("1", screening.getTitle());
    }

    @Test
    public void test_room() {
        screening.setroom("1");

        assertEquals("1", screening.getroom());
    }

    @Test
    public void test_name() {
        var now = LocalDateTime.now();
        screening.setDateTime(now);

        assertEquals(now, screening.getDateTime());
    }

    @Test
    public void test_full_constr() {
        var now = LocalDateTime.now();
        var screening2 = new Screening("title", "room", now);

        assertEquals(now, screening2.getDateTime());
        assertEquals("room", screening2.getroom());
        assertEquals("title", screening2.getTitle());
    }
}
