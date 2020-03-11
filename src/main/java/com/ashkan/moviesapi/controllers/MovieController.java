package com.ashkan.moviesapi.controllers;

import com.ashkan.moviesapi.entities.Movie;
import com.ashkan.moviesapi.services.interfaces.MovieService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieService movieService;
    private SimpleBeanPropertyFilter filter;

    @Autowired
    public MovieController(MovieService movieService,ModelMapper modelMapper) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        /*filter= SimpleBeanPropertyFilter.filterOutAllExcept("title","year","rate","actorsInMoviesById");
        FilterProvider filters=new SimpleFilterProvider().addFilter("MovieFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(movieService.findAll());
        mapping.setFilters(filters);*/
        return movieService.findAll();
    }

    @GetMapping("{Id}")
    public Movie getMovie(@PathVariable int Id) {
        return movieService.findById(Id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) throws Exception {
        movieService.save(movie);
        return movie;
    }

}
