package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT u FROM Movie as u " +
            "LEFT JOIN u.movieCatalogsById s " +
            "WHERE u.deleted=0")
    List<Movie> findAvailableMovies();
}
