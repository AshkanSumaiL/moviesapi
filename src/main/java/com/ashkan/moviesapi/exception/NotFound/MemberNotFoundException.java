package com.ashkan.moviesapi.exception.NotFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Integer id) {
        super("Member with id: '"+id.toString()+"' does not exists!");
    }
}
