package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Member;
import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.MovieCatalog;
import com.ashkan.moviesapi.entity.Price;
import com.ashkan.moviesapi.service.MovieCatalogService;
import com.ashkan.moviesapi.service.MovieService;
import com.ashkan.moviesapi.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieCatalogController {
    private MovieCatalogService movieCatalogService;
    private MovieService movieService;
    private PriceService priceService;


    @Autowired
    public MovieCatalogController(MovieCatalogService movieCatalogService,
                                  PriceService priceService,
                                  MovieService movieService) {
        this.movieCatalogService = movieCatalogService;
        this.movieService=movieService;
        this.priceService=priceService;
    }

    @GetMapping("/catalog-entry")
    public List<MovieCatalog> findAll() {
        return movieCatalogService.findAll();
    }

    @GetMapping("/catalog-entry/{Id}")
    public MovieCatalog getMovieCatalog(@PathVariable int Id) {
        return movieCatalogService.findById(Id);
    }

    @PostMapping("/catalog-entry")
    public MovieCatalog addMovieCatalog(@RequestBody MovieCatalog movieCatalog) {
        movieCatalogService.save(movieCatalog);
        return movieCatalog;
    }
}
