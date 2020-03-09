package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieRepository;
import com.ashkan.moviesapi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public Movie findById(int theId) {
        Optional<Movie> result = movieRepository.findById(theId);

        Movie movie = null;

        if (result.isPresent()) {
            movie = result.get();
        }
        else {
            throw new RuntimeException("Did not find the movie- " + theId);
        }

        return movie;
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(int theId) {
        movieRepository.deleteById(theId);
    }


}
