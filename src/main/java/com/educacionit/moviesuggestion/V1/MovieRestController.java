package com.educacionit.moviesuggestion.V1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.moviesuggestion.model.Movie;
import com.educacionit.moviesuggestion.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
	
	@Autowired
	MovieService movieService;

	@Operation(summary = "Devuelve un listado de peliculas", description = "No necesita parámetros de entrada", tags = { "Movies" })
	@GetMapping(value = "/", produces = "application/json")
	public @ResponseBody List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@Operation(summary = "Devuelve una película", description = "Ingresar ID de película", tags = { "Movies" })
	@GetMapping(value = "/{idpelicula}")
	public @ResponseBody Optional<Movie> getMovieById(@Parameter(description="id de la película") @PathVariable("idpelicula") Long id) {
		return movieService.getMovieById(id);
	}
	
	@Operation(summary = "Devuelve todas las de películas de un año específico (Native Query)", description = "Ingresar año de 4 dígitos", tags = { "Movies" })
	@GetMapping(value = "/year/{year}")
	public @ResponseBody List<Movie> getMoviesByYear(@PathVariable("year") Integer year) {
		return movieService.getMoviesByYear(year);
	}
	
	@Operation(summary = "Devuelve todas las de películas de un año específico (Criteria)", description = "Ingresar año de 4 dígitos", tags = { "Movies" })
	@GetMapping(value = "/year2/{year}")
	public @ResponseBody List<Movie> getMoviesByYear2(@PathVariable("year") Integer year) {
		return movieService.getMoviesByYear2(year);
	}
	
	
	
	
	
	
	
	@Operation(summary = "Devuelve todas las de películas de un año y una duración menor a un valor dado", description = "Ingresar año y duración", tags = { "Movies" })
	@GetMapping(value = "/yearandduration/")
	public @ResponseBody List<Movie> getMoviesByYearAndDurationLessThan(@RequestParam("year") Integer year, @RequestParam("duration") Integer duration) {
		return movieService.getMoviesByYearAndDurationLessThan(year,duration);
	}
	
	
	
	
	
	
	
	
	
	@Operation(summary = "Agregar Película", description = "Enviar el objeto película", tags = { "Movies" })
	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody Movie addUser(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@Operation(summary = "Elimina una película", description = "Enviar el id", tags = { "Movies" })
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public @ResponseBody String delMovie(@PathVariable("id") Long id) {
		return movieService.delMovie(id);
	}
	
	@Operation(summary = "Actualizar una película", description = "Enviar el objeto completo", tags = { "Movies" })
	@PutMapping(path = "/", produces = "application/json")
	public @ResponseBody Movie updUser(@RequestBody Movie movie) {
		return movieService.updMovie(movie);
	}
}
