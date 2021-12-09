package com.skewdev.cinephilia.repository;

import com.skewdev.cinephilia.entity.Review;
import com.skewdev.cinephilia.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findAllByMovieId(Long movieId);
    Boolean existsReviewByAuthor_IdAndMovieId(UUID authorId, Long movieId);
    Boolean existsReviewByAuthor_UsernameAndMovieId(String authorUsername, Long movieId);
}
