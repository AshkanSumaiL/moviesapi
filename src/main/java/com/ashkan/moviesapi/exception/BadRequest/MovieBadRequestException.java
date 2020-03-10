package com.ashkan.moviesapi.exception.BadRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Movie not found!")
public class MovieBadRequestException extends RuntimeException{
}
