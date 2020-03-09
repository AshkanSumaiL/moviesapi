package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieCatalogRepository;
import com.ashkan.moviesapi.entity.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCatalogServiveImpl implements  MovieCatalogService{
    private MovieCatalogRepository movieCatalogRepository;

    @Autowired
    public MovieCatalogServiveImpl(MovieCatalogRepository movieCatalogRepository) {
        this.movieCatalogRepository = movieCatalogRepository;
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
        movieCatalogRepository.save(movieCatalog);
    }

    @Override
    public void deleteById(int theId) {
        movieCatalogRepository.deleteById(theId);
    }
}
