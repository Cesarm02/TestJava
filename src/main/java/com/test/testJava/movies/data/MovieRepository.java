package com.test.testJava.movies.data;

import com.test.testJava.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie FindById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
    Collection<Movie> findByName(String name);
}
