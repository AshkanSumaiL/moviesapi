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
        Optional<Price> result = priceRepository.findById(theId);

        Price price;
        if (result.isPresent()) {
            price = result.get();
        }
        else {
            throw new RuntimeException("Did not find the price id- " + theId);
        }
        return price;
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
