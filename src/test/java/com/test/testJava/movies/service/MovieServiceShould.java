package com.test.testJava.movies.service;

import com.test.testJava.movies.data.MovieRepository;
import com.test.testJava.movies.model.Genre;
import com.test.testJava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService service;

    @Before
    public void setUp() throws Exception{
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knigth", 150, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There", 112, Genre.COMEDY),
                        new Movie(4, "Super 8", 111, Genre.THRILLER),
                        new Movie(5, " Scream", 136, Genre.HORROR)
                )
        );

        service = new MovieService(movieRepository);

    }

    @Test
    public void return_movie_by_genre(){

        Collection<Movie> movies = service.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(3)));
    }

    @Test
    public void return_movies_by_length(){
        Collection<Movie>  movies = service.findMoviesByLength(111);

        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(4)));

    }

    private static List<Integer> getMovieId(Collection<Movie> movies) {
        List<Integer> movieId = movies.stream().map(Movie::getId).collect(Collectors.toList());
        return movieId;
    }

}