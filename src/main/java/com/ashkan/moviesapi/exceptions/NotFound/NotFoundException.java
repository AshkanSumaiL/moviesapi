package com.ashkan.moviesapi.exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String resource,Integer id) {
        super(String.format("id:'%d' not found in resource:'%s'",id,resource));
    }
}
