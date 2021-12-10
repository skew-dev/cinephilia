package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.Movie;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> all(){
        List<Movie> movies = movieService.getAll();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> newMovie(@Valid @RequestBody Movie newMovie){
        Movie movie = movieService.addNewMovie(newMovie);
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> one(@PathVariable Long id){
        Movie movie = movieService.findMovieById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));
        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> replaceMovie(@Valid @RequestBody Movie newMovie, @PathVariable Long id){
        Movie updatedMovie = movieService.replaceMovie(newMovie, id);
        return ResponseEntity.ok().body(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
