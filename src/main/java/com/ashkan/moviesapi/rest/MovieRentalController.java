package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.MovieRental;
import com.ashkan.moviesapi.service.MovieRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRentalController {
    private MovieRentalService movieRentalService;

    @Autowired
    public MovieRentalController(MovieRentalService movieRentalService) {
        this.movieRentalService = movieRentalService;
    }

    @GetMapping("/movie-rental")
    public List<MovieRental> findAll() {
        return movieRentalService.findAll();
    }

    @GetMapping("/movie-rental/{Id}")
    public MovieRental getMovieMovieRental(@PathVariable int Id) {
        MovieRental movieRental = movieRentalService.findById(Id);
        if (movieRental== null) {
            throw new RuntimeException("Movie rental id not found - " + Id);
        }
        return movieRental;
    }

    @PostMapping("/movie-rental")
    public MovieRental addMovieRental(@RequestBody MovieRental movieRental) {
        //actor.setId(0);
        movieRentalService.save(movieRental);
        return movieRental;
    }
}
