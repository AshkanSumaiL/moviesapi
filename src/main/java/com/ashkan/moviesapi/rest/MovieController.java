package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Movie;

import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.service.MovieService;
import com.ashkan.moviesapi.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("{Id}")
    public Movie getMovie(@PathVariable int Id) {
        return movieService.findById(Id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        movieService.save(movie);
        return movie;
    }
}
