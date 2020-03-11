package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.repositories.PriceRepository;
import com.ashkan.moviesapi.entities.Price;
import com.ashkan.moviesapi.services.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
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
                orElseThrow(() -> new RuntimeException("Price id not found:" + theId));
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
