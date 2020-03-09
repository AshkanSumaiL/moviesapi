package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental, Integer> {
}
