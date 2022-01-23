package com.mygroup.myproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = -6958128182491079251L;

    public BadRequestException() {
        super();
    }

    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
