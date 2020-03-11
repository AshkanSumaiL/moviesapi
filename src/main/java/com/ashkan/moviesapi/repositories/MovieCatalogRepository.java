package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Integer> {
    @Query("SELECT u FROM MovieCatalog as u " +
            "WHERE u.movieId = :searchId")
    Optional<MovieCatalog> findByMovieId(@Param("searchId") int searchId);
}
