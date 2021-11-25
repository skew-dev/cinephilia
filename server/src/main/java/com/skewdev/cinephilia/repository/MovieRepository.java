package com.skewdev.cinephilia.repository;

import com.skewdev.cinephilia.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
