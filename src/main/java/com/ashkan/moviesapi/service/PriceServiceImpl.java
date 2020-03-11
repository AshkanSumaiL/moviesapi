package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.PriceRepository;
import com.ashkan.moviesapi.dao.UserRepository;
import com.ashkan.moviesapi.entity.Price;
import com.ashkan.moviesapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements  PriceService{
    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }


    @Override
    public Price findById(int theId) {
        return priceRepository.findById(theId).
                orElseThrow(()->new RuntimeException("Price id not found:"+theId));
    }

    @Override
    public void save(Price price) {
        priceRepository.save(price);
    }

    @Override
    public void deleteById(int theId) {
        priceRepository.deleteById(theId);
    }
}
