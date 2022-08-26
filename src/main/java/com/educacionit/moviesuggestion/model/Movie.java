package com.educacionit.moviesuggestion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="peliculas")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
//	@NotNull(message = "El id no puede ser nulo")
	private String name;
//	@NotNull(message = "El nombre no puede ser nulo")
	private Integer yearOfRelease;
//	@Range(min = 1900, max = 2022, message = "El año debe estar entre 1900 y 2022")
	private Integer duration;
//	@Range(min = 1, max = 5000, message = "La duración debe estar entre 1 y 5000 mintos")
	private String summary;


}
