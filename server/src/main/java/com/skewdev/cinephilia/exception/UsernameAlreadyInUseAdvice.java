package com.skewdev.cinephilia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsernameAlreadyInUseAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public String usernameAlreadyInUseHanlder(UsernameAlreadyInUseException ex){
       return ex.getMessage();
    }
}
