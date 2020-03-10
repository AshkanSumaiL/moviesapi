package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.MovieRental;

import java.util.List;

public interface MovieRentalService {
    public List<MovieRental> findAll();

    public MovieRental findById(int theId);

    public void save(MovieRental movieRental);

    public void deleteById(int theId);

    public void patchStatus(MovieRental movieRental,int theId);
}
