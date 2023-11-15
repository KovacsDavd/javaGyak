package com.epam.training.ticketservice.core.service;

import com.epam.training.ticketservice.core.entity.Room;

public interface RoomService extends CoreService<Room> {
    Room findByName(String title);
}
