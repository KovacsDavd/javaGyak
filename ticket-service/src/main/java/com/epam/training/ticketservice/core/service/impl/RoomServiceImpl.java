package com.epam.training.ticketservice.core.service.impl;

import com.epam.training.ticketservice.core.entity.Room;
import com.epam.training.ticketservice.core.repository.CoreRepository;
import com.epam.training.ticketservice.core.repository.RoomRepository;
import com.epam.training.ticketservice.core.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends CoreServiceImpl<Room> implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(CoreRepository<Room> entityRepository, RoomRepository roomRepository) {
        super(entityRepository);
        this.roomRepository = roomRepository;
    }
}
