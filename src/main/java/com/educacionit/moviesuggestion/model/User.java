package com.educacionit.moviesuggestion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Usuarios")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message = "El nombre no puede ser nulo")
	private Long Id;
	private String userName;
	private String nombreApe;
	private String clave;
	@Email(message = "La dirección de mail no es correcta")
	private String mail;
	@Range(min = 1, max = 120, message = "Nadie vive más de 120 años!")
	private Integer edad;
	

}
