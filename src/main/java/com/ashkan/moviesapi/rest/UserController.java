package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{Id}")
    public User getUser(@PathVariable int Id) {
        return userService.findById(Id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
