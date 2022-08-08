package com.test.testJava.movies.service;

import com.test.testJava.movies.data.MovieRepository;
import com.test.testJava.movies.model.Genre;
import com.test.testJava.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return repository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int i) {
        return repository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= i).collect(Collectors.toList());

    }

    public Collection<Movie> findByName(String name){
         return repository.findByName(name).stream().collect(Collectors.toList());
    }

}
