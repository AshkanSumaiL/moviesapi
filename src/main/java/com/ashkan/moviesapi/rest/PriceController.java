package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Price;
import com.ashkan.moviesapi.entity.User;
import com.ashkan.moviesapi.service.PriceService;
import com.ashkan.moviesapi.service.UserService;
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

    @GetMapping("{Id}")
    public Price getPrices(@PathVariable int Id) {
        return priceService.findById(Id);
    }

    @PostMapping
    public Price addPrice(@RequestBody Price price) {
        priceService.save(price);
        return price;
    }
}
