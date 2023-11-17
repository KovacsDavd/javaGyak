package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Movie;
import com.epam.training.ticketservice.core.entity.Screening;
import com.epam.training.ticketservice.core.service.MovieService;
import com.epam.training.ticketservice.core.service.ScreeningService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ScreeningCommandTest {

    @Mock
    private MovieService movieService;
    @Mock
    private ScreeningService screeningService;

    @InjectMocks
    private ScreeningCommand screeningCommand;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_create_screening_null() {
        when(screeningService.findByRoom(anyString())).thenReturn(Collections.emptyList());

        String res = screeningCommand.createScreening("Title", "room", "2022-01-01 15:23");

        assertEquals("Successful addition", res);
        verify(screeningService, times(1)).save(any(Screening.class));
    }

    @Test
    public void test_create_screening_overlapping() {
        var movie = new Movie();
        var screening = new Screening();

        screening.setDateTime(LocalDateTime.of(2023, 1, 1, 15, 22));
        screening.setroom("room");
        screening.setTitle("Title");

        movie.setLength(2);
        movie.setTitle("Title");

        when(screeningService.findByRoom(anyString())).thenReturn(List.of(screening));
        when(movieService.findByTitle(anyString())).thenReturn(movie);

        String res = screeningCommand.createScreening("Title", "room", "2023-01-01 15:23");

        assertEquals("There is an overlapping screening", res);
        verify(screeningService, times(0)).save(any(Screening.class));
    }

    @Test
    public void test_create_screening_break_period() {
        var movie = new Movie();
        var screening = new Screening();

        screening.setDateTime(LocalDateTime.of(2023, 1, 1, 15, 20));
        screening.setroom("room");
        screening.setTitle("Title");

        movie.setLength(2);
        movie.setTitle("Title");

        when(screeningService.findByRoom(anyString())).thenReturn(List.of(screening));
        when(movieService.findByTitle(anyString())).thenReturn(movie);

        String res = screeningCommand.createScreening("Title", "room", "2023-01-01 15:23");

        assertEquals("This would start in the break period after another screening in this room", res);
        verify(screeningService, times(0)).save(any(Screening.class));
    }

    @Test
    public void test_delete_screening_null() {
        when(screeningService.findByTitleAndRoomAndTime(anyString(), anyString(), any(LocalDateTime.class)))
                .thenReturn(null);

        String res = screeningCommand.deleteScreening("Title", "a", "2022-01-01 15:23");

        assertEquals("Screening is not exists", res);
        verify(screeningService, times(0)).delete(any(Screening.class));
    }

    @Test
    public void test_delete_screening() {
        var screening = new Screening();
        screening.setroom("r");
        screening.setTitle("t");
        screening.setDateTime(LocalDateTime.now());
        when(screeningService.findByTitleAndRoomAndTime(anyString(), anyString(), any(LocalDateTime.class)))
                .thenReturn(screening);

        String res = screeningCommand.deleteScreening("r", "t", "2022-01-01 15:23");

        assertEquals("Successful delete", res);
        verify(screeningService, times(1)).delete(any(Screening.class));
    }

    @Test
    public void test_list_screenings_empty() {
        when(screeningService.findAll()).thenReturn(Collections.emptyList());

        String res = screeningCommand.listScreening();

        assertEquals("There are no screenings", res);
    }

    @Test
    public void test_list_screenings() {
        var screening = new Screening();
        var movie = new Movie();
        var now = LocalDateTime.now();

        movie.setGenre("g");
        movie.setTitle("t");
        movie.setLength(1);

        screening.setroom("name");
        screening.setTitle("1");
        screening.setDateTime(now);

        when(screeningService.findAll()).thenReturn(List.of(screening));
        when(movieService.findByTitle("1")).thenReturn(movie);

        String res = screeningCommand.listScreening();

        verify(movieService, times(1)).findByTitle(anyString());
    }
}
