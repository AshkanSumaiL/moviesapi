package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.MovieCatalog;

import java.util.List;

public interface MovieCatalogService {
    List<MovieCatalog> findAll();

    MovieCatalog findById(int theId);

    void save(MovieCatalog movieCatalog);

    void deleteById(int theId);
}
