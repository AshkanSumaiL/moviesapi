package com.ashkan.moviesapi.controllers;

import com.ashkan.moviesapi.entities.MovieCatalog;
import com.ashkan.moviesapi.services.interfaces.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog-entry")
public class MovieCatalogController {
    private MovieCatalogService movieCatalogService;

    @Autowired
    public MovieCatalogController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    @GetMapping
    public List<MovieCatalog> findAll() {
        return movieCatalogService.findAll();
    }

    @GetMapping("{id}")
    public MovieCatalog getMovieCatalog(@PathVariable int id) {
        return movieCatalogService.findById(id);
    }

    @PostMapping
    public MovieCatalog addMovieCatalog(@RequestBody MovieCatalog movieCatalog) {
        movieCatalogService.save(movieCatalog);
        return movieCatalog;
    }
}
