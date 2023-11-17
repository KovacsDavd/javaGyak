package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.repository.ScreeningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ScreeningServiceImplTest {

    @InjectMocks
    private ScreeningServiceImpl screeningService;

    @Mock
    private ScreeningRepository screeningRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_find_by_room() {
        screeningService.findByRoom("a");
        verify(screeningRepository, times(1)).findByRoom("a");
    }

    @Test
    public void test_find_by_title_and_room_and_time() {
        var now = LocalDateTime.now();
        screeningService.findByTitleAndRoomAndTime("a", "r", now);
        verify(screeningRepository, times(1)).findByTitleAndRoomAndTime("a", "r", now);
    }
}
