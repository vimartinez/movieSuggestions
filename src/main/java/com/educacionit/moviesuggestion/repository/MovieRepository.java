package com.educacionit.moviesuggestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.educacionit.moviesuggestion.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {
	
	@Query(nativeQuery= true,
		    value = "SELECT * FROM peliculas WHERE year_of_release = :year")
			List<Movie> getMoviesByYear(Integer year);



}
