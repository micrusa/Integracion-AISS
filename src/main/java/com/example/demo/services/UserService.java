package com.example.demo.services;

import com.example.demo.model.user.ListUsers;
import com.example.demo.model.user.SingleUser;
import com.example.demo.model.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    private RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> findAllUsers(int page) {
        ListUsers obj = restTemplate.getForObject("https://reqres.in/api/users?page=" + page, ListUsers.class);
        return obj == null ? null : obj.getData();
    }

    public User findUser(int id) {
        SingleUser obj = restTemplate.getForObject("https://reqres.in/api/users/" + id, SingleUser.class);
        return obj == null ? null : obj.getData();
    }
}
