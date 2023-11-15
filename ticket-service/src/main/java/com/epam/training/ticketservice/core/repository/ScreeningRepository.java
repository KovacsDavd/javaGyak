package com.epam.training.ticketservice.core.repository;

import com.epam.training.ticketservice.core.entity.Screening;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends CoreRepository<Screening> {
    Screening findByTitleAndRoomAndTime(String title, String room, LocalDateTime time);

    List<Screening> findByRoom(String room);
}
