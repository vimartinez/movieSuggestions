package com.educacionit.moviesuggestion.repository;

import java.util.List;

import com.educacionit.moviesuggestion.model.Movie;

public interface MovieRepositoryCustom{

			List<Movie> getMoviesByYear2(Integer year);
			
			List<Movie> getMoviesByYearAndDurationLessThan(Integer year, Integer duration);

}
