package com.skewdev.cinephilia.service;

import com.skewdev.cinephilia.entity.Review;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.repository.MovieRepository;
import com.skewdev.cinephilia.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public Review addNewReview(Review review){
        final long movieId = review.getMovieId();
        validateMovie(movieId);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByMovieId(Long movieId){
        validateMovie(movieId);
        return reviewRepository.findByMovieId(movieId);
    }

    private void validateMovie(Long movieId){
        if(!movieRepository.existsById(movieId)){
            throw new MovieNotFoundException(movieId);
        }
    }
}
