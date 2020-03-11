package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.Movie;

import java.util.List;

public interface MovieService {
        public List<Movie> findAll();

        public Movie findById(int theId);

        public void save(Movie actor) throws Exception;

        public void deleteById(int theId);
}
