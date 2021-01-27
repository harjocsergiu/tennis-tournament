package com.demo.tennistournament.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlacerHolderException extends RuntimeException{
    public PlacerHolderException(String message) {
        super(message);
    }
}
