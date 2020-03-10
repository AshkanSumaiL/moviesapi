package com.ashkan.moviesapi.exception.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Integer id) {
        super("Movie with id: '" + id.toString() + "' does not exists!");
    }
}


