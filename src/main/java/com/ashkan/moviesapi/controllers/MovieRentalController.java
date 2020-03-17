package com.ashkan.moviesapi.controllers;


import com.ashkan.moviesapi.entities.MovieRental;
import com.ashkan.moviesapi.services.interfaces.MovieRentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie-rental")
public class MovieRentalController {
    private MovieRentalService movieRentalService;

    @Autowired
    public MovieRentalController(MovieRentalService movieRentalService) {
        this.movieRentalService = movieRentalService;
    }

    @GetMapping
    public List<MovieRental> findAll() {
        return movieRentalService.findAll();
    }

    @GetMapping("{id}")
    public MovieRental getMovieMovieRental(@PathVariable int id) {
        return movieRentalService.findById(id);
    }

    @PatchMapping("{id}")
    public void patchMovieMovieRental(@RequestBody MovieRental movieRental, @PathVariable int id) {
        movieRentalService.patchStatus(movieRental, id);
    }

    @PostMapping
    public MovieRental addMovieRental(@RequestBody MovieRental movieRental) {
        movieRentalService.save(movieRental);
        return movieRental;
    }

}
