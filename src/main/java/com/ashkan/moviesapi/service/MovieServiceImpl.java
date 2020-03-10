package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MovieRepository;
import com.ashkan.moviesapi.dao.UserRepository;
import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.exception.NotFound.MemberNotFoundException;
import com.ashkan.moviesapi.exception.NotFound.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;
    private UserRepository userRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public Movie findById(int theId) {
        return  movieRepository.findById(theId)
                .orElseThrow(()->new MovieNotFoundException(theId));
    }

    @Override
    public void save(Movie movie) {
        Optional<User> user= userRepository.findById(movie.getUserId());
        if (!user.isPresent()) {
            throw new MovieNotFoundException(movie.getUserId());
        }
        movie.setUserByUserId(user.get());
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(int theId) {
        movieRepository.deleteById(theId);
    }


}
