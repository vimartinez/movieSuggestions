package com.educacionit.moviesuggestion.V1;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.moviesuggestion.model.User;
import com.educacionit.moviesuggestion.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {
	
	@Operation(summary = "getAllUsers", description = "No implementado", tags = { "Users" })
	@GetMapping(value = "/", produces = "application/json")
	public @ResponseBody List<User> getAllUsers() {
		log.info("getAllUsers en UserRestController");
		return UserService.getAllUsers();
	}
	
	@Operation(summary = "getUserById", description = "No implementado", tags = { "Users" })
	@GetMapping(value = "/{id}")
	public @ResponseBody Optional<User> getUserById(@PathVariable("id") Long id) {
		log.info("getUserById en UserRestController");
		return UserService.getUserById(id);
	}
	
	@Operation(summary = "addUser", description = "No implementado", tags = { "Users" })
	@PostMapping(path = "/", produces = "application/json")
	public @ResponseBody User addUser(@RequestBody User user) {
		log.info("addUser en UserRestController");
		return UserService.addUser(user);
	}
	
	@Operation(summary = "delUser", description = "No implementado", tags = { "Users" })
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public @ResponseBody String delUser(@PathVariable("id") Long id) {
		log.info("delUser en UserRestController");
		return UserService.delUser(id);
	}
	
	@Operation(summary = "updUser", description = "No implementado", tags = { "Users" })
	@PutMapping(path = "/", produces = "application/json")
	public @ResponseBody User updUser(@RequestBody User user) {
		log.info("updUser en UserRestController");
		return UserService.addUser(user);
	}
	

}
