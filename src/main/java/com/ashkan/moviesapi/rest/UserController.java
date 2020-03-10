package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{Id}")
    public User getUser(@PathVariable int Id) {
        User user = userService.findById(Id);
        if (user== null) {
            throw new RuntimeException("User id not found - " + Id);
        }
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
