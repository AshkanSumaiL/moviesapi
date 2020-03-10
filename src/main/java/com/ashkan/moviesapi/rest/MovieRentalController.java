package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.DTO.MovieRentalPatchDTO;
import com.ashkan.moviesapi.entity.*;
import com.ashkan.moviesapi.service.MemberService;
import com.ashkan.moviesapi.service.MovieRentalService;
import com.ashkan.moviesapi.service.MovieService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie-rental")
public class MovieRentalController {
    private MovieRentalService movieRentalService;

    private ModelMapper modelMapper;


    @Autowired
    public MovieRentalController(MovieRentalService movieRentalService,
                                 ModelMapper modelMapper) {
        this.movieRentalService = movieRentalService;
        this.modelMapper=modelMapper;
    }

    @GetMapping
    public List<MovieRental> findAll() {
        return movieRentalService.findAll();
    }

    @GetMapping("{Id}")
    public MovieRental getMovieMovieRental(@PathVariable int Id) {
        return movieRentalService.findById(Id);
    }

    @PatchMapping("{Id}")
    public void patchMovieMovieRental(@RequestBody MovieRentalPatchDTO movieRentalPatchDTO,@PathVariable int Id) {
        movieRentalService.patchStatus(convertToEntity(movieRentalPatchDTO),Id);
    }

    @PostMapping
    public MovieRental addMovieRental(@RequestBody MovieRental movieRental) {
        movieRentalService.save(movieRental);
        return movieRental;
    }

    private MovieRental convertToEntity(MovieRentalPatchDTO movieRentalPatchDTO){
        MovieRental movieRental = modelMapper.map(movieRentalPatchDTO, MovieRental.class);
        movieRental.setStatus(movieRentalPatchDTO.getStatus());
        return movieRental;
    }
}
