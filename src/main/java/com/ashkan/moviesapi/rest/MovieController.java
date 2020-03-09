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
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movie/{Id}")
    public Movie getMovie(@PathVariable int Id) {
        Movie movie = movieService.findById(Id);
        if (movie== null) {
            throw new RuntimeException("Movie id not found - " + Id);
        }
        return movie;
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {

        /*User user = userService.findById(movie.getUserId());
        logger.info(String.valueOf(user.getName()));*/

        List<User> users = userService.findAll();
        for(User user:users){
            logger.info(String.valueOf(user.getName()));
        }

        movieService.save(movie);
        return movie;
    }
}
