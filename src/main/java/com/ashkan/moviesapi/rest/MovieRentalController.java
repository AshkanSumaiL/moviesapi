package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.*;
import com.ashkan.moviesapi.service.MemberService;
import com.ashkan.moviesapi.service.MovieRentalService;
import com.ashkan.moviesapi.service.MovieService;
import com.ashkan.moviesapi.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRentalController {
    private MovieRentalService movieRentalService;
    private MovieService movieService;
    private MemberService memberService;

    Logger logger = LoggerFactory.getLogger(MovieRentalController.class);

    @Autowired
    public MovieRentalController(MovieRentalService movieRentalService,
                                MovieService movieService,
                                 MemberService memberService) {
        this.movieRentalService = movieRentalService;
        this.memberService=memberService;
        this.movieService=movieService;
    }

    @GetMapping("/movie-rental")
    public List<MovieRental> findAll() {
        return movieRentalService.findAll();
    }

    @GetMapping("/movie-rental/{Id}")
    public MovieRental getMovieMovieRental(@PathVariable int Id) {
        return movieRentalService.findById(Id);
    }

    @PatchMapping("/movie-rental/{Id}")
    public void patchMovieMovieRental(@RequestBody MovieRental movieRental,@PathVariable int Id) {
        movieRentalService.patchStatus(movieRental,Id);
    }

    @PostMapping("/movie-rental")
    public MovieRental addMovieRental(@RequestBody MovieRental movieRental) {
        movieRentalService.save(movieRental);
        return movieRental;
    }
}
