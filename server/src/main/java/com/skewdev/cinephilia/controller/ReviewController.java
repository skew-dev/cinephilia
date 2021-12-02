package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.Review;
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
    public ResponseEntity<?> newReview(@PathVariable Long movieId, @RequestBody Review newReview){
        newReview.setMovieId(movieId);
        Review review = reviewService.addNewReview(newReview);
        return ResponseEntity.ok().body(review);
    }

    @GetMapping
    public ResponseEntity<List<Review>> allReviewsForMovie(@PathVariable Long movieId){
        List<Review> reviews = reviewService.getReviewsByMovieId(movieId);
        return ResponseEntity.ok().body(reviews);
    }


}
