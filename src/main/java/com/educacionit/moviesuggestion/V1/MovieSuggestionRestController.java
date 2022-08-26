package com.educacionit.moviesuggestion.V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.moviesuggestion.model.MovieAPI;
import com.educacionit.moviesuggestion.service.MovieSuggestionsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mve")
@Slf4j
//@CrossOrigin
public class MovieSuggestionRestController {
	@Autowired 
	MovieSuggestionsService movieSuggestionService;
	
	@Operation(summary = "Devuelve un listado de películas segú el nombre ingresado", description = "Ingresar nombre completo en ingles o parte", tags = { "Movie Suggestion" })
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Operación exitosa"),
	        @ApiResponse(responseCode = "404", description = "NO se encontraron perículas") })
	@GetMapping(value="/", produces = "Application/json")
	public @ResponseBody Iterable<MovieAPI> getMovieByName( @Parameter(description="Nombre de la película") @RequestParam(value="Nombre", defaultValue="Back to the future") String name) {
		
		log.info("getMovieByName en RestController");
		return movieSuggestionService.getMoviesByName(name);
	}
	
	@Operation(summary = "Devuelve películas recomendadas según el nombre de una película", description = "Ingresar nombre completo en ingles o parte", tags = { "Movie Suggestion" })
	@GetMapping(value="/suggestions/", produces = "Application/json")
	public @ResponseBody Iterable<MovieAPI> getRecommendedMovies(String name){
		log.info("getMoviesRecommende en MovieSuggetionRestController");
		return movieSuggestionService.getRecommendedMovies(name);
		
	}

}
