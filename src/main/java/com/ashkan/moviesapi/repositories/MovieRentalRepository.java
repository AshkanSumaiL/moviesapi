package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental, Integer> {
}
