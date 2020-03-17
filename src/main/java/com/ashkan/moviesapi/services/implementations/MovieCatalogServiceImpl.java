package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.exceptions.Conflict.ConflictException;
import com.ashkan.moviesapi.exceptions.NotFound.NotFoundException;
import com.ashkan.moviesapi.repositories.MovieCatalogRepository;
import com.ashkan.moviesapi.repositories.MovieRepository;
import com.ashkan.moviesapi.repositories.PriceRepository;
import com.ashkan.moviesapi.entities.Movie;
import com.ashkan.moviesapi.entities.MovieCatalog;
import com.ashkan.moviesapi.entities.Price;
import com.ashkan.moviesapi.services.interfaces.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {
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
    public MovieCatalog findById(int id) {
        return movieCatalogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movie Catalog",id));
    }

    @Override
    public void save(MovieCatalog movieCatalog) {
        Movie movie = movieRepository.findById(movieCatalog.getMovieId())
                .orElseThrow(() -> new NotFoundException("Movies",movieCatalog.getMovieId()));
        Price price = priceRepository.findById(movieCatalog.getPriceId())
                .orElseThrow(() -> new NotFoundException("Prices",movieCatalog.getPriceId()));

        Optional<MovieCatalog> movieCatalogFind = movieCatalogRepository.findByMovieId(movie.getId());

        if (!movieCatalogFind.isPresent()) {
            movieCatalog.setMovie(movie);
            movieCatalog.setPrice(price);
            movieCatalogRepository.save(movieCatalog);
        } else {
            throw new ConflictException("This movie already exists in catalog:"+movie.getTitle());
        }
    }

    @Override
    public void deleteById(int id) {
        movieCatalogRepository.deleteById(id);
    }
}
