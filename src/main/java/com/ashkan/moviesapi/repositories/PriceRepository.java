package com.ashkan.moviesapi.repositories;


import com.ashkan.moviesapi.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
