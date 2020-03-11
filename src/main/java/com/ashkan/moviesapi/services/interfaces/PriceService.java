package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.Price;

import java.util.List;

public interface PriceService {
    List<Price> findAll();

    Price findById(int theId);

    void save(Price actor);

    void deleteById(int theId);
}
