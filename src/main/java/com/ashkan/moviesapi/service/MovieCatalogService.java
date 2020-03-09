package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.MovieCatalog;

import java.util.List;

public interface MovieCatalogService {
    public List<MovieCatalog> findAll();

    public MovieCatalog findById(int theId);

    public void save(MovieCatalog movieCatalog);

    public void deleteById(int theId);
}
