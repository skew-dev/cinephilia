package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.Review;
import com.skewdev.cinephilia.exception.AlreadyReviewedMovieException;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies/{movieId}/reviews")
public class ReviewController {
    final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<?> writeReview(@PathVariable Long movieId, @RequestBody Review newReview){
        validateMovie(movieId);
        if (reviewService.hasUserReviewedMovie(newReview.getAuthorId(), movieId))
            throw new AlreadyReviewedMovieException(newReview.getAuthorId(), movieId);

        newReview.setMovieId(movieId);
        Review review = reviewService.addNewReview(newReview);
        return ResponseEntity.ok().body(review);
    }

    @GetMapping
    public ResponseEntity<List<Review>> allReviewsForMovie(@PathVariable Long movieId){
        validateMovie(movieId);

        List<Review> reviews = reviewService.getReviewsByMovieId(movieId);
        return ResponseEntity.ok().body(reviews);
    }

    private void validateMovie(Long movieId){
        if (!reviewService.doesMovieExists(movieId))
            throw new MovieNotFoundException(movieId);
    }
}
