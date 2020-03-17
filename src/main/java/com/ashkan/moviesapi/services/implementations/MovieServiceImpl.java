package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.constants.Constants;
import com.ashkan.moviesapi.entities.Actor;
import com.ashkan.moviesapi.exceptions.BadRequest.BadRequestException;
import com.ashkan.moviesapi.exceptions.NotFound.NotFoundException;
import com.ashkan.moviesapi.repositories.ActorRepository;
import com.ashkan.moviesapi.repositories.MovieRepository;
import com.ashkan.moviesapi.repositories.UserRepository;
import com.ashkan.moviesapi.entities.Movie;
import com.ashkan.moviesapi.entities.User;
import com.ashkan.moviesapi.exceptions.NotFound.MovieNotFoundException;
import com.ashkan.moviesapi.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ActorRepository actorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            UserRepository userRepository,
                            ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.actorRepository=actorRepository;
    }

    @Override
    public List<Movie> findAll() {
        // return movieRepository.findAll();
        return movieRepository.findAvailableMovies();
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movies",id));
    }

    @Override
    public void save(Movie movie) throws Exception {
        User userFind = userRepository.findById(movie.getUserId())
                .orElseThrow(() -> new NotFoundException("Users",movie.getUserId()));
        movie.setUser(userFind);
        
        if (Constants.RATES.contains(movie.getRate())) {
            movie.setDeleted((byte)0);
            movieRepository.save(movie);
        } else {
            throw new BadRequestException("Rates allowed:" + Constants.RATES.toString());
        }
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }


}
