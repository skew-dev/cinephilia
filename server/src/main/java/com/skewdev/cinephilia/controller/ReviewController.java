package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.Author;
import com.skewdev.cinephilia.entity.Review;
import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.exception.AlreadyReviewedMovieException;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.service.ReviewService;
import com.skewdev.cinephilia.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("movies/{movieId}/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    final UsersService usersService;

    public ReviewController(ReviewService reviewService, UsersService usersService) {
        this.reviewService = reviewService;
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<?> writeReview(Principal principal, @PathVariable Long movieId, @Valid @RequestBody Review newReview){
        validateMovie(movieId);
        User authenticatedUser = usersService.getUser(principal.getName());
        newReview.setAuthor(new Author(authenticatedUser));

        if (reviewService.hasUserReviewedMovie(authenticatedUser, movieId))
            throw new AlreadyReviewedMovieException(newReview.getAuthor().getId().toString(), movieId);

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
