package com.educacionit.moviesuggestion.mapper;

import org.json.JSONObject;
import com.educacionit.moviesuggestion.model.MovieAPI;

public class MovieMapper {

	public static MovieAPI jsonObjectToMovie (JSONObject jsonObject) {
		MovieAPI movie = new MovieAPI();
		movie.setId(Integer.parseInt(jsonObject.get("id").toString()));
		movie.setMovieName(jsonObject.get("title").toString());
		movie.setMovieDescription(jsonObject.getString("synopsis"));
		movie.setCover(jsonObject.getString("medium_cover_image"));
		
		return movie;
		
	}

}
