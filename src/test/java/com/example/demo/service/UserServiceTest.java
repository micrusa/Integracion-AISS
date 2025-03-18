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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        //System.out.println("Users: " + users);
    }

    @Test
    @DisplayName("Find User by ID")
    public void findUser() {
        for(int id : new int[]{1,2,3}) {
            User user = userService.findUser(id);
            assertNotNull(user, "User is null");
            //System.out.println("User " + id + ": " + user);
        }
    }
}
