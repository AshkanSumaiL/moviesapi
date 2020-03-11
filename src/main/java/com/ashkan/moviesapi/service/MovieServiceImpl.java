package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.constants.constants;
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
       // return movieRepository.findAll();
        return movieRepository.findAvailableMovies();
    }

    @Override
    public Movie findById(int theId) {
        return  movieRepository.findById(theId)
                .orElseThrow(()->new MovieNotFoundException(theId));
    }

    @Override
    public void save(Movie movie) throws Exception {
        User userFind = userRepository.findById(movie.getUserId())
                .orElseThrow(()->new RuntimeException("User id not found"));
        movie.setUserByUserId(userFind);
        if(constants.Rates.contains(movie.getRate())){
            movieRepository.save(movie);
        }
        else{
            throw new Exception("Rates allowed:"+constants.Rates.toString());
        }

    }

    @Override
    public void deleteById(int theId) {
        movieRepository.deleteById(theId);
    }


}
