package com.educacionit.moviesuggestion;


import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.educacionit.moviesuggestion.V1.MovieRestController;
import com.educacionit.moviesuggestion.model.Movie;
import com.educacionit.moviesuggestion.repository.MovieRepository;
import com.educacionit.moviesuggestion.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest()
class MoviesuggestionApplicationTests {
	
	@Autowired
	MovieRestController movieRestController;
	
	//@Autowired
	//private TestRestTemplate restTemplate;

	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieRepository movieRepository;

  /*  @BeforeAll
    static void beforeAll() {
        System.out.println("Comenzando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test");
    }

	@BeforeEach
    void initTestCase() {
        System.out.println("  iniciando el testcase.");
    }
	

    @AfterEach
    void finTestCase() {
        System.out.println("  finalizando testcasea.");
    }*/
	
	@Test
	void contextLoads() {
		Assertions.assertNotNull(movieRestController);
	}
	
	//@Test
	//public void greetingShouldReturnDefaultMessage() throws Exception {
		//Movie movie = this.restTemplate.getForObject("http://localhost:" + 8126 + "/movies/1",	Movie.class);
		//Assertions.assertEquals(movie.getClass(),Movie.class);
//	}
	
	@Test
	void testMovieService() {
		//Assertions.assertNotNull(movieService.getMovieById(1L));
		Optional<Movie> movie = movieService.getMovieById(1L);
		Assertions.assertNotNull(movie);
		Assertions.assertEquals(movie.get().getClass(), Movie.class);
	}
	
	@Test
	@DisplayName("Probando acceso a datos")
	void testMovieRepository() {
		Assertions.assertNotNull(movieService.getMovieById(1L));
	}
	
	@Test
	void testAddMovie() {
		Movie movie = new Movie(null,"Argo",2018,135,"Pelicula de guerra");
		Assertions.assertNotNull(movieRepository.save(movie));
	}

}
