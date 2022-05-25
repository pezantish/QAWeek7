package com.qa.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.spring.domain.ZooAnimal;
import com.qa.spring.repository.ZooAnimalRepository;

@Service
public class ZooAnimalService {

	private List<ZooAnimal> animals = new ArrayList<>();
	private ZooAnimalRepository repo;

	public ZooAnimalService(ZooAnimalRepository repo) {
		this.repo = repo;
	}

	// Read -> Get Request
	// Search by ID
	public ZooAnimal readById(long id) {
//		return animals.get((int) id);
		return this.repo.findById(id).get();
	}

	// Read for all
	public List<ZooAnimal> readAll() {
//		return animals;
		return this.repo.findAll();
	}

	// Create -> Post Request
	public ZooAnimal create(ZooAnimal animal) {
//		animals.add(animal);
//		return animals.get(animals.size() - 1);
		return this.repo.saveAndFlush(animal);
	}

	// Full Update -> Put Request
	public ZooAnimal replace(long id, ZooAnimal animal) {
//		animals.remove((int) id);
//		animals.add((int) id, animal);
//		return animals.get((int) id);
		ZooAnimal replacedAnimal = readById(id);
		replacedAnimal.setAll(animal.getName(), animal.getSpecies(), animal.getEnvironment());
		return this.repo.saveAndFlush(replacedAnimal);
	}

//	public ZooAnimal replace(String name, String species, String environment, long id) {
//		animals.remove((int) id);
//		ZooAnimal animal = new ZooAnimal(id, name, species, environment);
//		animals.add((int) id, animal);
//		return animals.get((int) id);
//	}

	// Partial Update -> Patch Request
	public ZooAnimal update(String name, long id) {
//		ZooAnimal animal = animals.get((int) id);
//		animal.setName(name);
//		return animal;
		ZooAnimal replacedAnimal = readById(id);
		replacedAnimal.setName(name);
		return this.repo.saveAndFlush(replacedAnimal);
	}

	// Delete -> Delete Request
	public boolean delete(long id) {
//		try {
//			animals.remove((int) id);
//			animals.add((int) id, null);
//			return true;
//		} catch (Exception e) {
//			System.out.println(e);
//			return false;
//		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
