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
public class MovieCatalogServiceImpl implements  MovieCatalogService{
    private MovieCatalogRepository movieCatalogRepository;
    private MovieRepository movieRepository;
    private PriceRepository priceRepository;

    @Autowired
    public MovieCatalogServiceImpl(MovieCatalogRepository movieCatalogRepository,
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
        return movieCatalogRepository.findById(theId)
                .orElseThrow(()->new RuntimeException("Did not find the movie catalog - " + theId));
    }

    @Override
    public void save(MovieCatalog movieCatalog) {
        Movie movie = movieRepository.findById(movieCatalog.getMovieId())
                .orElseThrow(()->new RuntimeException("Did not find the movie  - " + movieCatalog.getMovieId()));
        Price price= priceRepository.findById(movieCatalog.getPriceId())
                .orElseThrow(()->new RuntimeException("Did not find the price  - " + movieCatalog.getPriceId()));

        movieCatalog.setMovieByMovieId(movie);
        movieCatalog.setPriceByPriceId(price);
        movieCatalogRepository.save(movieCatalog);
    }

    @Override
    public void deleteById(int theId) {
        movieCatalogRepository.deleteById(theId);
    }
}
