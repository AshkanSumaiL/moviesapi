package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.Price;

import java.util.List;

public interface PriceService {
    List<Price> findAll();

    Price findById(int id);

    void save(Price actor);

    void deleteById(int id);
}
