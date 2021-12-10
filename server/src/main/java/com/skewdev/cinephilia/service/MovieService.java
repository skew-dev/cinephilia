package com.skewdev.cinephilia.service;

import com.skewdev.cinephilia.entity.Movie;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Movie replaceMovie(Movie newMovie, Long id){
        Movie updatedMovie = movieRepository.findById(id)
                .map(m->{
                    m.setTitle(newMovie.getTitle());
                    m.setReleaseDate(newMovie.getReleaseDate());
                    m.setOverview(newMovie.getOverview());
                    m.setPosterPath(newMovie.getPosterPath());
                    m.setUpdatedAt(newMovie.getUpdatedAt());
                    return movieRepository.save(m);
                })
                .orElseThrow(()-> new MovieNotFoundException(id));
        return updatedMovie;
    }

    public void deleteMovie(Long id) {
        try{
            movieRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new MovieNotFoundException(id);
        }
    }
}
