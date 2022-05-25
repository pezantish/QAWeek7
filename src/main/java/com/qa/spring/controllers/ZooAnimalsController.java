package com.qa.spring.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.spring.domain.ZooAnimal;
import com.qa.spring.services.ZooAnimalService;

@RestController
public class ZooAnimalsController {

	private ZooAnimalService service;

	public ZooAnimalsController(ZooAnimalService service) {
		this.service = service;
	}

	// Read -> Get Request
	// Search by ID
	@GetMapping("/readById/{id}")
	public ZooAnimal readById(@PathVariable long id) {
		return service.readById(id);
	}

	// Read for all
	@GetMapping("/readAll")
	public List<ZooAnimal> readAll() {
		return service.readAll();
	}

	// Create -> Post Request
	@PostMapping("/create")
	public ZooAnimal create(@RequestBody ZooAnimal animal) {
		return service.create(animal);
	}

	// Full Update -> Put Request
	@PutMapping("/replace/{id}")
	public ZooAnimal replace(@PathVariable long id, @RequestBody ZooAnimal animal) {
		return service.replace(id, animal);
	}
//	public ZooAnimal replace(@PathParam("name") String name, @PathParam("species") String species,
//			@PathParam("environment") String environment, @PathVariable long id) {
//		return service.replace(name, species, environment, id);
//	}

	// Partial Update -> Patch Request
	@PatchMapping("/update/{id}")
	public ZooAnimal update(@PathParam("name") String name, @PathVariable long id) {
		return service.update(name, id);
	}

	// Delete -> Delete Request
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}
}
