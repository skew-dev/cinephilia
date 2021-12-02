package com.skewdev.cinephilia.repository;

import com.skewdev.cinephilia.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByMovieId(Long movieId);
}
