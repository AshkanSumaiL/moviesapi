package com.ashkan.moviesapi.controllers;

import com.ashkan.moviesapi.entities.Price;
import com.ashkan.moviesapi.services.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    private PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<Price> findAll() {
        return priceService.findAll();
    }

    @GetMapping("{id}")
    public Price getPrices(@PathVariable int id) {
        return priceService.findById(id);
    }

    @PostMapping
    public Price addPrice(@RequestBody Price price) {
        priceService.save(price);
        return price;
    }
}
