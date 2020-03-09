package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieRentalRepository;
import com.ashkan.moviesapi.entity.MovieRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieRentalServiceImpl implements  MovieRentalService{
    private MovieRentalRepository movieRentalRepository;

    @Autowired
    public MovieRentalServiceImpl(MovieRentalRepository movieRentalRepository) {
        this.movieRentalRepository = movieRentalRepository;
    }

    @Override
    public List<MovieRental> findAll() {
        return movieRentalRepository.findAll();
    }

    @Override
    public MovieRental findById(int theId) {
        Optional<MovieRental> result = movieRentalRepository.findById(theId);

        MovieRental movieRental = null;

        if (result.isPresent()) {
            movieRental = result.get();
        }
        else {
            throw new RuntimeException("Did not find the movie rental- " + theId);
        }

        return movieRental;
    }

    @Override
    public void save(MovieRental movieRental) {
            movieRentalRepository.save(movieRental);
    }

    @Override
    public void deleteById(int theId) {
        movieRentalRepository.deleteById(theId);
    }
}
