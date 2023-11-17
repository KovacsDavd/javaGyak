package com.epam.training.ticketservice.core.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    private Room room;

    @BeforeEach
    public void init() {
        room = new Room();
    }

    @Test
    public void test_id() {
        room.setId(1L);

        assertEquals(Long.valueOf(1), room.getId());
    }

    @Test
    public void test_row_number() {
        room.setRowNumber(1);

        assertEquals(1, room.getRowNumber());
    }

    @Test
    public void test_column_number() {
        room.setColumnNumber(1);

        assertEquals(1, room.getColumnNumber());
    }

    @Test
    public void test_name() {
        room.setName("1");

        assertEquals("1", room.getName());
    }

    @Test
    public void test_to_string() {
        var room2 = new Room("name", 1, 1);
        var exp = "Room name with 1 seats, 1 rows and 1 columns";
        assertEquals(exp, room2.toString());
    }
}
