package com.educacionit.moviesuggestion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="critica")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@NotNull(message = "El id no puede ser nulo")
	private Integer review;
	@NotNull(message = "El review no puede ser nulo")
	private Long movieId;
	@NotNull(message = "El id de la película no puede ser nulo")
	private String comment;
	

}
