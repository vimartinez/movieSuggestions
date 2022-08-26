package com.educacionit.moviesuggestion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieAPI {
	
	private Integer Id;
	private String movieName;
	private String movieDescription;
	private String cover;	

}
