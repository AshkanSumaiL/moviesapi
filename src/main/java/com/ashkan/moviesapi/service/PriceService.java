package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.Movie;
import com.ashkan.moviesapi.entity.Price;

import java.util.List;

public interface PriceService {
    public List<Price> findAll();

    public Price findById(int theId);

    public void save(Price actor);

    public void deleteById(int theId);
}
