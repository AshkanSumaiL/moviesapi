package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(int theId);

    void save(Movie actor) throws Exception;

    void deleteById(int theId);
}
