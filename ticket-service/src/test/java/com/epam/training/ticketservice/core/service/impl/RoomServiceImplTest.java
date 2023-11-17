package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.Room;
import com.epam.training.ticketservice.core.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RoomServiceImplTest {

    @InjectMocks
    private RoomServiceImpl roomService;

    @Mock
    private RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_find_by_name() {
        roomService.findByName("a");
        verify(roomRepository, times(1)).findByName("a");
    }

    @Test
    public void test_find_all() {
        roomService.findAll();
        verify(roomRepository, times(1)).findAll();
    }

    @Test
    public void test_delete() {
        var room = new Room();
        roomService.delete(room);
        verify(roomRepository, times(1)).delete(room);
    }

    @Test
    public void test_save() {
        var room = new Room();
        roomService.save(room);
        verify(roomRepository, times(1)).save(room);
    }
}
