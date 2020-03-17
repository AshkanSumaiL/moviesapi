package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User actor);

    void deleteById(int id);
}
