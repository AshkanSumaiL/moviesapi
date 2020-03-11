package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int theId);

    void save(User actor);

    void deleteById(int theId);
}
