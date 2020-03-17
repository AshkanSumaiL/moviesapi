package com.ashkan.moviesapi.exceptions.BadRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MovieRentalBadRequestException_NoCopies extends RuntimeException {
    public MovieRentalBadRequestException_NoCopies() {
        super("There are no more available copies");
    }
}
