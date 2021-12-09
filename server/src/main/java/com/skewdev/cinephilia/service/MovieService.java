package com.skewdev.cinephilia.service;

import com.skewdev.cinephilia.entity.Movie;
import com.skewdev.cinephilia.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Movie addNewMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Optional<Movie> findMovieById(Long id){
        return movieRepository.findById(id);
    }
}
