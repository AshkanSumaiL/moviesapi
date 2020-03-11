package com.ashkan.moviesapi.exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieRentalNotFoundException extends RuntimeException {
    public MovieRentalNotFoundException(Integer id) {
        super("Movie Rental with id: '" + id.toString() + "' does not exists!");
    }
}
