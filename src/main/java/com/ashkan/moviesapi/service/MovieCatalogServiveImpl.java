package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieCatalogRepository;
import com.ashkan.moviesapi.dao.MovieRepository;
import com.ashkan.moviesapi.dao.PriceRepository;
import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.MovieCatalog;
import com.ashkan.moviesapi.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCatalogServiveImpl implements  MovieCatalogService{
    private MovieCatalogRepository movieCatalogRepository;
    private MovieRepository movieRepository;
    private PriceRepository priceRepository;

    @Autowired
    public MovieCatalogServiveImpl(MovieCatalogRepository movieCatalogRepository,
                                   PriceRepository priceRepository,
                                   MovieRepository movieRepository) {
        this.movieCatalogRepository = movieCatalogRepository;
        this.priceRepository = priceRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieCatalog> findAll() {
        return movieCatalogRepository.findAll();
    }

    @Override
    public MovieCatalog findById(int theId) {
        Optional<MovieCatalog> result = movieCatalogRepository.findById(theId);

        MovieCatalog movieCatalog = null;

        if (result.isPresent()) {
            movieCatalog = result.get();
        }
        else {
            throw new RuntimeException("Did not find the movie catalog- " + theId);
        }

        return movieCatalog;
    }

    @Override
    public void save(MovieCatalog movieCatalog) {
        Optional<Movie> movie = movieRepository.findById(movieCatalog.getMovieId());
        Optional<Price> price= priceRepository.findById(movieCatalog.getPriceId());
        if (!movie.isPresent()) {
            throw new RuntimeException("movie id not found - " + movieCatalog.getMovieId());
        }
        if (!price.isPresent()) {
            throw new RuntimeException("price id not found - " + movieCatalog.getPriceId());
        }
        movieCatalog.setMovieByMovieId(movie.get());
        movieCatalog.setPriceByPriceId(price.get());
        movieCatalogRepository.save(movieCatalog);
    }

    @Override
    public void deleteById(int theId) {
        movieCatalogRepository.deleteById(theId);
    }
}
