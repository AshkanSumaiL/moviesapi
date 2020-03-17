package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.MovieRental;

import java.util.List;

public interface MovieRentalService {
    List<MovieRental> findAll();

    MovieRental findById(int id);

    void save(MovieRental movieRental);

    void deleteById(int id);

    void patchStatus(MovieRental movieRental, int id);
}
