package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class loginCommand {

    @Autowired
    UserService userService;
    private boolean isLogged = false;

    @ShellMethod(key = "sign in privileged", value = "Sign in to your account")
    public String login(String username, String password) {
        if (!isLogged) {
            if (userService.findByUsernameAndPassword(username, password) == null) {
                return "Login failed due to incorrect credentials";
            }
            isLogged = true;
            return "Successful login";
        }
        return "Signed in with privileged account " + userService.findAll().get(0).getUsername();
    }

    @ShellMethod(key = "sign out", value = "Sign out from your account")
    public void signOut() {
        if (isLogged) {
            isLogged = false;
        }
    }

    @ShellMethod(key = "describe account", value = "Account property")
    public String describe() {
        return isLogged ? "Signed in with privileged account " + userService.findAll().get(0).getUsername()
                : "You are not signed in";
    }
}
