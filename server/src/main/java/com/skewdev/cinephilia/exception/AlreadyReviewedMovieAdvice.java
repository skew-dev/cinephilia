package com.skewdev.cinephilia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlreadyReviewedMovieAdvice {
    @ResponseBody
    @ExceptionHandler(AlreadyReviewedMovieException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String alreadyReviewedMovieHandler(AlreadyReviewedMovieException ex) {return ex.getMessage();}
}
