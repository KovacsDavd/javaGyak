package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Screening;
import com.epam.training.ticketservice.core.service.MovieService;
import com.epam.training.ticketservice.core.service.ScreeningService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class ScreeningCommand extends CommandAvailability {

    private final ScreeningService screeningService;
    private final MovieService movieService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public ScreeningCommand(ScreeningService screeningService, MovieService movieService) {
        this.screeningService = screeningService;
        this.movieService = movieService;
    }

    @ShellMethod(key = "create screening", value = "Create screening")
    @ShellMethodAvailability(value = "isAdmin")
    public String createScreening(String name, String room, String time) {
        var formattedTime = LocalDateTime.parse(time, formatter);
        var screenings = screeningService.findByRoom(room);
        for (var screening : screenings) {
            var movieEntity = movieService.findByTitle(screening.getTitle());
            if (formattedTime.isBefore(screening.getDateTime().plusMinutes(movieEntity.getLength()))
                    && formattedTime.isAfter(screening.getDateTime())) {
                return "There is an overlapping screening";
            }
            if (formattedTime.isBefore(screening.getDateTime().plusMinutes(movieEntity.getLength() + 10))
                    && formattedTime.isAfter(screening.getDateTime())) {
                return "This would start in the break period after another screening in this room";
            }
        }
        screeningService.save(new Screening(name, room, formattedTime));
        return "Successful addition";
    }

    @ShellMethod(key = "delete screening", value = "Delete screening")
    @ShellMethodAvailability(value = "isAdmin")
    public String deleteScreening(String name, String room, String time) {
        var formattedTime = LocalDateTime.parse(time, formatter);
        var screening = screeningService.findByTitleAndRoomAndTime(name, room, formattedTime);
        if (screening != null) {
            screeningService.delete(screening);
            return "Successful delete";
        }
        return "Screening is not exists";
    }

    @ShellMethod(key = "list screenings", value = "List screening")
    public String listScreening() {
        var screenings = screeningService.findAll();
        StringBuilder res = new StringBuilder();
        if (screenings.isEmpty()) {
            return "There are no screenings";
        }
        for (var screening : screenings) {
            var movie = movieService.findByTitle(screening.getTitle());
            res.append(movie.getTitle() + " (" + movie.getGenre() + ", " + movie.getLength() + " minutes), screened in room "
                    + screening.getroom() + ", at " + screening.getDateTime().format(formatter) + "\n");
        }
        return res.toString();
    }
}
