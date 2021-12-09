package com.skewdev.cinephilia.service;

import com.skewdev.cinephilia.entity.Review;
import com.skewdev.cinephilia.entity.User;
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
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByMovieId(Long movieId){
        return reviewRepository.findAllByMovieId(movieId);
    }

    public boolean doesMovieExists(Long movieId){
        return movieRepository.existsById(movieId);
    }

    public boolean hasUserReviewedMovie(User author, Long movieId){
        return reviewRepository.existsReviewByAuthor_IdAndMovieId(author.getId(),movieId);
    }
}
