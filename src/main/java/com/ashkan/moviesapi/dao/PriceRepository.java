package com.ashkan.moviesapi.dao;


import com.ashkan.moviesapi.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
