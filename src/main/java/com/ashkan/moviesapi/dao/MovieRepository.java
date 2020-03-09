package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
   /* @Query("SELECT u FROM Movie u WHERE u.deleted = false")
    public List<Movie> findAvailableMovies();*/
}
