package com.ashkan.moviesapi.exception.BadRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieRentalBadRequestException2 extends RuntimeException {
    public MovieRentalBadRequestException2() {
        super("There are no more available copies");
    }
}
