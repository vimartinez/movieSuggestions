package com.educacionit.moviesuggestion.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.educacionit.moviesuggestion.mapper.MovieMapper;
import com.educacionit.moviesuggestion.model.MovieAPI;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
@Slf4j
public class MovieSuggestionsService {
	
	private final String urlListMoviesYTS = "https://yts.mx/api/v2/list_movies.json?query_term=";
	private final String urlListMovieSugestionsYTS = "https://yts.mx/api/v2/movie_suggestions.json?movie_id=";
	
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray;
	
	public Iterable<MovieAPI> getMoviesByName(String name){
		log.info("getMoviesByName en MovieSuggestionsService");
		ArrayList<MovieAPI> moviesList = new ArrayList<MovieAPI>();
		
		jsonObject = getMoviesFromYTS(urlListMoviesYTS, name);
		if(jsonObject.getInt("movie_count")>0) {
			jsonArray = jsonObject.getJSONArray("movies");
			for (int i=0;i<jsonArray.length();i++) {
				MovieAPI movie = new MovieAPI();
//				movie.setId(Integer.parseInt(jsonArray.getJSONObject(i).get("id").toString()));
//				movie.setMovieName(jsonArray.getJSONObject(i).get("title").toString());
//				movie.setMovieDescription(jsonArray.getJSONObject(i).getString("synopsis"));
//				movie.setCover(jsonArray.getJSONObject(i).getString("large_cover_image"));
				movie = MovieMapper.jsonObjectToMovie(jsonArray.getJSONObject(i));
				moviesList.add(movie);
			}
			//jsonObject.getJSONArray("movies").stream().forEach(x -> moviesList.add(x));
			//List<String> listTitles = new ArrayList<>();
	        //itemRepository.findItemsWithAverageRatingLowerThan(rating).stream().forEach(x -> listTitles.add(x.getTitle()));
			
		}
		
		
		
		return moviesList;
	}
	
	public Iterable<MovieAPI> getRecommendedMovies(String name) {
		
		log.info("getRecommendedMovies en MovieSuggestionsService");
		ArrayList<MovieAPI> moviesList = new ArrayList<MovieAPI>();
		Integer movieId = null;
		jsonObject = getMoviesFromYTS(urlListMoviesYTS, name);
		if(jsonObject.getInt("movie_count")>0) {
			movieId = jsonObject.getJSONArray("movies").getJSONObject(0).getInt("id");
			jsonObject = getMoviesFromYTS(urlListMovieSugestionsYTS, movieId.toString());
			if(jsonObject.getInt("movie_count")>0) {
				jsonArray = jsonObject.getJSONArray("movies");
				for (int i=0;i<jsonArray.length();i++) {
					MovieAPI movie = new MovieAPI();
					movie = MovieMapper.jsonObjectToMovie(jsonArray.getJSONObject(i));
					moviesList.add(movie);
				}
			}
		}
		return moviesList;
	}
	
	private JSONObject getMoviesFromYTS(String urlService, String data) {
		log.info("getMoviesFromYTS en MovieSuggestionsService");
		OkHttpClient httpClient = new OkHttpClient();
		Request request = new Request.Builder()
				.url(urlService+data)
				.build();
		
		Call call= httpClient.newCall(request);
		Response response;
		JSONObject jsonObject = null;
		
		try {
			response = call.execute();
			jsonObject = new JSONObject(response.body().string());
			if(jsonObject.get("status").equals("ok")) {
				jsonObject = jsonObject.getJSONObject("data");
			}
			else {
				throw new IOException("El servicio no respondió correctamente");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}


	
	
/*	@Autowired
	RestTemplate restTemplate;
	
	public MovieYTS[] getMovieByName(String name) {
		log.info("getMovieByName en MovieSuggestionsService");
		//MovieYTS movie = restTemplate.getForObject(urlListMoviesYTS+name, MovieYTS.class);
		ResponseEntity<MovieYTS[]> response =
				  restTemplate.getForEntity(
						  urlListMoviesYTS+name,
				  MovieYTS[].class);
		MovieYTS[] movies = response.getBody();
		//return Optional.of(movies);
		return movies;
	
	}*/
	

}
