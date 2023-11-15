package com.epam.training.ticketservice.ui.commands;

import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class UserCommand extends CommandAvailability {

    private final UserService userService;

    public UserCommand(UserService userService) {
        this.userService = userService;
    }

    @ShellMethod(key = "sign in privileged", value = "Sign in to your account")
    @ShellMethodAvailability(value = "isNotLogged")
    public String login(String username, String password) {
        if (userService.findByUsernameAndPassword(username, password) == null) {
            return "Login failed due to incorrect credentials";
        }
        setLogged(true);
        return "Successful login";
    }

    @ShellMethod(key = "sign out", value = "Sign out from your account")
    @ShellMethodAvailability(value = "isLogged")
    public void signOut() {
        setLogged(false);
    }

    @ShellMethod(key = "describe account", value = "Account property")
    public String describe() {
        return getLogged() ? "Signed in with privileged account " + userService.findAll().get(0).getUsername()
                : "You are not signed in";
    }
}
