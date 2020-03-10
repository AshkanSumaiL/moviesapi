package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.MovieCatalog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //@Query("SELECT u FROM Movie u WHERE u.deleted = 0")
    @Query("SELECT u FROM Movie as u LEFT JOIN u.movieCatalogsById")
    List<Movie> findAvailableMovies();
}
