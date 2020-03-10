package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Movie;

import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.service.MovieService;
import com.ashkan.moviesapi.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;
    private UserService userService;

    @Autowired
    public MovieController(MovieService movieService,UserService userService) {
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{Id}")
    public Movie getMovie(@PathVariable int Id) {
        return movieService.findById(Id);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        movieService.save(movie);
        return movie;
    }
}
