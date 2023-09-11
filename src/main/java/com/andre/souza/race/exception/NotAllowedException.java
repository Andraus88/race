package com.andre.souza.race.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAllowedException extends Exception{
    public NotAllowedException(String message){
        super(message);
    }
}

