package com.ashkan.moviesapi.exceptions.BadRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieRentalBadRequestException extends RuntimeException {
    public MovieRentalBadRequestException() {
        super("Movie Rental status allowed 'status' should be 'Returned'");
    }
}
