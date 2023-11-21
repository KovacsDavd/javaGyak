package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;

public class CommandAvailability {

    @Autowired
    UserService userService;

    private static boolean isLogged = false;

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public boolean getLogged() {
        return isLogged;
    }


    public Availability isLogged() {
        return isLogged ? Availability.available() : Availability.unavailable("");
    }

    public Availability isNotLogged() {
        return isLogged ? Availability.unavailable("") : Availability.available();
    }

    public Availability isAdmin() {
        return isLogged && userService.findAll().get(0).isAdmin()
                ? Availability.available() : Availability.unavailable("");
    }
}
