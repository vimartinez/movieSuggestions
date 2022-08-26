package com.educacionit.moviesuggestion;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
public class MoviesuggestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesuggestionApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("V1") String appVersion) {
		return new OpenAPI().info(new Info().title("Movie Suggestion API")
				.version(appVersion)
				.description("API to suggest movies")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://sprindoc.org")));
	}

}
