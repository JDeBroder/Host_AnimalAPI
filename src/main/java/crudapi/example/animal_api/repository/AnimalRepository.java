package crudapi.example.animal_api.repository;

import crudapi.example.animal_api.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// interface for CRUD operations for the animal model
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
// method to find all animal records that match species
    List<Animal> findBySpecies(String species);
// method to find animal records where name contains a given string
    List<Animal> findByNameContaining(String name);
}
