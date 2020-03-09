package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.MovieCatalog;
import com.ashkan.moviesapi.service.MovieCatalogService;
import com.ashkan.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {
    private MovieCatalogService movieCatalogService;


    @Autowired
    public MovieCatalogController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    @GetMapping("/movie-entry")
    public List<MovieCatalog> findAll() {
        return movieCatalogService.findAll();
    }


    @PostMapping("/movie-entry")
    public MovieCatalog addMovieCatalog(@RequestBody MovieCatalog movieCatalog) {
        //actor.setId(0);
        movieCatalogService.save(movieCatalog);
        return movieCatalog;
    }
}
