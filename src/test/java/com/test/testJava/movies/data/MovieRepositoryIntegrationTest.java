package com.test.testJava.movies.data;

import com.test.testJava.movies.model.Genre;
import com.test.testJava.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        //Conexión BD
         dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        //Ejecutando script para la db
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        //template
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        //repositorio
         movieRepository = new MovieRepositoryJdbc(jdbc);

    }

    @Test
    public void load_all_movies()  {

        //Recuperar peliculas
        Collection<Movie> movies = movieRepository.findAll();
        //Comprobar que sean correctas
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie (1,"Dark Knight", 152, Genre.ACTION),
                new Movie(2,"Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));

    }

    @Test
    public void load_movie_by_id(){
        Movie movie = movieRepository.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento",113, Genre.THRILLER)));
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
        movieRepository.saveOrUpdate(movie);

        Movie movieExpected = movieRepository.findById(4);

        assertThat(movieExpected, CoreMatchers.is(new Movie(4,"Super 8", 112, Genre.THRILLER)));

    }

    @Test
    public void find_by_name(){
        Collection<Movie> movieName= movieRepository.findByName("M");
        assertThat(movieName, CoreMatchers.is(Arrays.asList(
                new Movie(2,"Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @After
    public void tearDown () throws Exception{
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }

}