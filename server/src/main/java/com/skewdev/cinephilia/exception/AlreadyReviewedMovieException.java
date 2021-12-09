package com.skewdev.cinephilia.exception;

public class AlreadyReviewedMovieException extends RuntimeException {
    public AlreadyReviewedMovieException(String userId, Long movieId) {
        super("User with id " + userId + " already reviewed movie with id " + movieId);
    }
}
