package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.MovieCatalog;

import java.util.List;

public interface MovieCatalogService {
    List<MovieCatalog> findAll();

    MovieCatalog findById(int id);

    void save(MovieCatalog movieCatalog);

    void deleteById(int id);
}
