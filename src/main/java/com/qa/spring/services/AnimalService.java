package com.qa.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.spring.domain.Animal;
import com.qa.spring.exceptions.AnimalNotFoundException;
import com.qa.spring.repository.AnimalRepository;

@Service
public class AnimalService {

	private AnimalRepository repo;

	public AnimalService(AnimalRepository repo) {
		this.repo = repo;
	}

	// Read -> Get Request
	// Search by ID
	public Animal readById(long id) {
		return this.repo.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
	}

	// Read for all
	public List<Animal> readAll() {
//		return animals;
		return this.repo.findAll();
	}
	
	public List<Animal> readByNameAndSpecies(String name, String species) {
//		return animals;
		return this.repo.findByNameAndSpeciesSQL(name, species);
	}

	// Create -> Post Request
	public Animal create(Animal animal) {
//		animals.add(animal);
//		return animals.get(animals.size() - 1);
		return this.repo.saveAndFlush(animal);
	}

	// Full Update -> Put Request
	public Animal replace(long id, Animal animal) {
//		animals.remove((int) id);
//		animals.add((int) id, animal);
//		return animals.get((int) id);
		Animal replacedAnimal = readById(id);
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
	public Animal update(String name, long id) {
//		ZooAnimal animal = animals.get((int) id);
//		animal.setName(name);
//		return animal;
		Animal replacedAnimal = readById(id);
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
