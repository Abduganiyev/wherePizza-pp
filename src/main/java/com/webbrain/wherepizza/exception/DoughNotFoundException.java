package com.webbrain.wherepizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoughNotFoundException extends RuntimeException{
    public DoughNotFoundException(String message) {
        super(message);
    }
}
