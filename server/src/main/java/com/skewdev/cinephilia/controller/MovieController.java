package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.Movie;
import com.skewdev.cinephilia.exception.MovieNotFoundException;
import com.skewdev.cinephilia.repository.MovieRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;
    private final MovieModelAssembler assembler;

    public MovieController(MovieRepository movieRepository, MovieModelAssembler assembler) {
        this.movieRepository = movieRepository;
        this.assembler = assembler;
    }

    @GetMapping("/movies")
    public CollectionModel<EntityModel<Movie>> all(){
        List<EntityModel<Movie>> movies = movieRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return  CollectionModel.of(movies,
                linkTo(methodOn(MovieController.class).all()).withSelfRel());
    }

    @PostMapping("/movies")
    ResponseEntity<?> newMovie(@RequestBody Movie newMovie){
        EntityModel<Movie> movie = assembler.toModel(movieRepository.save(newMovie));
        return ResponseEntity
                .created(movie.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(movie);
    }

    @GetMapping("/movies/{id}")
    public EntityModel<Movie> one(@PathVariable Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));
        return assembler.toModel(movie);
    }

    @PutMapping("/movies/{id}")
    ResponseEntity<?> replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id){
        Movie updatedMovie = movieRepository.findById(id)
                .map(m->{
                    m.setTitle(newMovie.getTitle());
                    m.setReleaseDate(newMovie.getReleaseDate());
                    m.setOverview(newMovie.getOverview());
                    return movieRepository.save(m);
                })
                .orElseGet(()->{
                    newMovie.setId(id);
                    return movieRepository.save(newMovie);
                });

        EntityModel<Movie> entityModel = assembler.toModel(updatedMovie);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/movies/{id}")
    ResponseEntity<?> deleteMovie(@PathVariable Long id){
        try{
            movieRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new MovieNotFoundException(id);
        }

        return  ResponseEntity.noContent().build();
    }
}
