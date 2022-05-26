package com.qa.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.spring.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	
	List<Animal> findZooAnimalByName(String name);
	
	@Query(value = "SELECT * FROM zoo_animal WHERE name = ?1 AND species = ?2", nativeQuery = true)
	List<Animal> findByNameAndSpeciesSQL(String name, String species);

}
