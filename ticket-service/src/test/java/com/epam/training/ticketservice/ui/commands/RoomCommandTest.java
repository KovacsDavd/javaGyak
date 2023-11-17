package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Room;
import com.epam.training.ticketservice.core.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RoomCommandTest {
    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomCommand roomCommand;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_create_room_null() {
        when(roomService.findByName(anyString())).thenReturn(null);

        String res = roomCommand.createRoom("Title", 1, 120);

        assertEquals("Successful addition", res);
        verify(roomService, times(1)).save(any(Room.class));
    }

    @Test
    public void test_create_room() {
        when(roomService.findByName(anyString())).thenReturn(new Room());

        String res = roomCommand.createRoom("Title", 1, 120);

        assertEquals("Room is already exists", res);
        verify(roomService, times(0)).save(any(Room.class));
    }

    @Test
    public void test_update_room() {
        when(roomService.findByName(anyString())).thenReturn(new Room());

        String res = roomCommand.updateRoom("Title", 1, 150);

        assertEquals("Successful update", res);
        verify(roomService, times(1)).save(any(Room.class));
    }

    @Test
    public void test_update_room_null() {
        when(roomService.findByName(anyString())).thenReturn(null);

        String res = roomCommand.updateRoom("Title", 1, 150);

        assertEquals("Room is not exists", res);
        verify(roomService, times(0)).save(any(Room.class));
    }

    @Test
    public void test_delete_room_null() {
        when(roomService.findByName(anyString())).thenReturn(null);

        String res = roomCommand.deleteRoom("Title");

        assertEquals("Room is not exists", res);
        verify(roomService, times(0)).delete(any(Room.class));
    }

    @Test
    public void test_delete_room() {
        when(roomService.findByName(anyString())).thenReturn(new Room());

        String res = roomCommand.deleteRoom("Title");

        assertEquals("Successful delete", res);
        verify(roomService, times(1)).delete(any(Room.class));
    }

    @Test
    public void test_list_rooms_empty() {
        when(roomService.findAll()).thenReturn(Collections.emptyList());

        String res = roomCommand.listRoom();

        assertEquals("There are no rooms at the moment", res);
    }

    @Test
    public void test_list_rooms() {
        var room = new Room();
        room.setName("name");
        room.setColumnNumber(1);
        room.setRowNumber(2);

        when(roomService.findAll()).thenReturn(List.of(room));

        String res = roomCommand.listRoom();

        assertEquals("Room name with 2 seats, 2 rows and 1 columns", res);
    }
}
