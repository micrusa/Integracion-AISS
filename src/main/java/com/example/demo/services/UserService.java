package com.example.demo.services;

import com.example.demo.model.user.ListUsers;
import com.example.demo.model.user.SingleUser;
import com.example.demo.model.user.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService {
    private final RestTemplate restTemplate;

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

    public User createUser(User user) {
        User newUser = restTemplate.postForObject("https://reqres.in/api/users", user, User.class);
        return newUser;
    }

    public User updateUser(int id, User user) throws URISyntaxException {
        HttpEntity<User> req = new HttpEntity<>(user);
        User updatedUser = restTemplate.exchange(new URI("https://reqres.in/api/users/" + id), HttpMethod.PUT, req, User.class).getBody();
        return user;
    }

    public void deleteUser(int id) {
        restTemplate.delete("https://reqres.in/api/users/" + id);
    }
}
