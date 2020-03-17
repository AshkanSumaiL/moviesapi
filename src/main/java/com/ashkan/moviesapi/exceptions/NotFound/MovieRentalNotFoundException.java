package com.ashkan.moviesapi.exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieRentalNotFoundException extends RuntimeException {
    public MovieRentalNotFoundException(Integer id) {
        super(String.format("Movie Rental with id: '%d' does not exists",id));
    }
}
