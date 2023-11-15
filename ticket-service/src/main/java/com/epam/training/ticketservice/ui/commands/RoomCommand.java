package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.entity.Room;
import com.epam.training.ticketservice.core.service.impl.RoomServiceImpl;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class RoomCommand extends CommandAvailability {

    private final RoomServiceImpl roomService;

    public RoomCommand(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @ShellMethod(key = "create room", value = "Create room")
    @ShellMethodAvailability(value = "isAdmin")
    public String createRoom(String name, int rowNumber, int columnNumber) {
        if (roomService.findByName(name) == null) {
            roomService.save(new Room(name, rowNumber, columnNumber));
            return "Successful addition";
        }
        return "Room is already exists";
    }

    @ShellMethod(key = "update room", value = "Update room")
    @ShellMethodAvailability(value = "isAdmin")
    public String updateRoom(String name, int rowNumber, int columnNumber) {
        var room = roomService.findByName(name);
        if (room != null) {
            room.setRowNumber(rowNumber);
            room.setColumnNumber(columnNumber);
            roomService.save(room);
            return "Successful update";
        }
        return "Room is not exists";
    }

    @ShellMethod(key = "delete room", value = "Delete room")
    @ShellMethodAvailability(value = "isAdmin")
    public String deleteRoom(String name) {
        var room = roomService.findByName(name);
        if (room != null) {
            roomService.delete(room);
            return "Successful delete";
        }
        return "Room is not exists";
    }

    @ShellMethod(key = "list room", value = "List room")
    public String listRoom() {
        var rooms = roomService.findAll();
        StringBuilder res = new StringBuilder();
        if (rooms.isEmpty()) {
            return "There are no rooms at the moment";
        }
        for (var room : rooms) {
            res.append(room.toString());
        }
        return res.toString();
    }
}
