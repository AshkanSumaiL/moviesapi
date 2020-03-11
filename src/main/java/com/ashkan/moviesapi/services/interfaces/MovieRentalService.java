package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.MovieRental;

import java.util.List;

public interface MovieRentalService {
    List<MovieRental> findAll();

    MovieRental findById(int theId);

    void save(MovieRental movieRental);

    void deleteById(int theId);

    void patchStatus(MovieRental movieRental, int theId);
}
