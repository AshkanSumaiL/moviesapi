package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int theId);

    public void save(User actor);

    public void deleteById(int theId);
}
