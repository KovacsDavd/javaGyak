package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService extends CoreService<Screening> {
    Screening findByTitleAndRoomAndTime(String title, String room, LocalDateTime time);

    List<Screening> findByRoom(String room);
}
