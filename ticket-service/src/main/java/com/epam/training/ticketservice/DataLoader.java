package com.epam.training.ticketservice;

import com.epam.training.ticketservice.core.entity.User;
import com.epam.training.ticketservice.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public DataLoader(UserService userService) {
        this.userService = userService;
        addAdmin();
    }

    private void addAdmin() {
        if (userService.findByUsernameAndPassword("admin", "admin") == null) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");

            userService.save(user);
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
