package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.Screening;
import com.epam.training.ticketservice.core.repository.ScreeningRepository;
import com.epam.training.ticketservice.core.service.ScreeningService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningServiceImpl extends CoreServiceImpl<Screening> implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        super(screeningRepository);
        this.screeningRepository = screeningRepository;
    }

    @Override
    public Screening findByTitleAndRoomAndTime(String title, String room, LocalDateTime time) {
        return screeningRepository.findByTitleAndRoomAndTime(title, room, time);
    }

    @Override
    public List<Screening> findByRoom(String room) {
        return screeningRepository.findByRoom(room);
    }
}
