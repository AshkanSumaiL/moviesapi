package com.ashkan.moviesapi.exceptions.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Integer id) {
        super(String.format("Member with id: '%d' does not exists",id));
    }
}
