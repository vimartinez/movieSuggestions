package com.educacionit.moviesuggestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.moviesuggestion.model.Movie;
import com.educacionit.moviesuggestion.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
		
	}

	public  Optional<Movie> getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	public  Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public String delMovie(Long id) {
		movieRepository.deleteById(id);
		return null;
	}

	public  Movie updMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<Movie> getMoviesByYear(Integer year) {
		return movieRepository.getMoviesByYear(year);
	}

	public List<Movie> getMoviesByYear2(Integer year) {
		return movieRepository.getMoviesByYear2(year);
	}

	
	public List<Movie> getMoviesByYearAndDurationLessThan(Integer year, Integer duration) {
		log.info("Year:"+year+" Duration:"+duration);
		return movieRepository.getMoviesByYearAndDurationLessThan(year,duration);
	}

}
