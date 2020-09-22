package com.user.controllers;

import com.user.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private Map<String, User> userMap;

    @PostConstruct
    public void initMap() {
        userMap = new HashMap<>();
        for (int i = 0; i <= 5; i++) {
            String id = "user - " + i;
            userMap.put(id, new User(id, "User " + i, "user" + i + "@gmail.com"));
        }
    }

    @GetMapping(value = "")
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") String id) {
        User user = userMap.get(id);
        if (null == user) {
            throw new IllegalArgumentException("User not found for : " + id);
        }
        return user;
    }
}
