package com.epam.training.ticketservice.core.repository;

import com.epam.training.ticketservice.core.entity.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CoreRepository<Room> {
    Room findByName(String name);
}
