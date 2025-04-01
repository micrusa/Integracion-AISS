package com.example.demo.service;

import com.example.demo.model.user.User;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("Find All Users")
    public void findAllUsers() {
        List<User> users = userService.findAllUsers(1);
        assertNotNull(users, "Users list is null");
        assertFalse(users.isEmpty(), "Users list is empty");
        System.out.println("Users: " + users);
    }

    @Test
    @DisplayName("Find User by ID")
    public void findUser() {
        for(int id : new int[]{1,2,3}) {
            User user = userService.findUser(id);
            assertNotNull(user, "User is null");
            System.out.println("User " + id + ": " + user);
        }
    }

    @Test
    @DisplayName("Create User")
    public void createUser() {
        User user = new User();
        user.setFirstName("Juan");
        user.setEmail("juan@gmail.com");
        User newUser = userService.createUser(user);
        assertNotNull(newUser, "New user is null");
        assertNotNull(newUser.getId(), "New user ID is null");
        System.out.println("Created User: " + newUser);
    }

    @Test
    @DisplayName("Update User")
    public void updateUser() throws URISyntaxException {
        User user = new User();
        user.setFirstName("Juan");
        user.setEmail("juan@gmail.com");
        User newUser = userService.createUser(user);

        user.setEmail("juan1@gmail.com");
        User updatedUser = userService.updateUser(newUser.getId(), user);

        assertNotNull(updatedUser, "Updated user is null");
        assertEquals(updatedUser.getEmail(), user.getEmail(), "User email not updated");
    }

    @Test
    @DisplayName("Delete User")
    public void deleteUser() {
        User user = new User();
        user.setFirstName("Juan");
        user.setEmail("juan@gmail.com");
        User newUser = userService.createUser(user);
        userService.deleteUser(newUser.getId());
        try {
            User deletedUser = userService.findUser(newUser.getId());
            assertNull(deletedUser, "Deleted user is not null");
        } catch(HttpClientErrorException.NotFound ignore) {
            // Pass
        }
    }
}
