package com.ashkan.moviesapi.exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Integer id) {
        super(String.format("Movie with id: '%d' does not exists",id));
    }
}


