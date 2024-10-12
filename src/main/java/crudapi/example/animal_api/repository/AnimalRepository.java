package crudapi.example.animal_api.repository;

import crudapi.example.animal_api.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CRUD interface
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // find all animal records that match species
    List<Animal> findBySpeciesIgnoreCase(String species);

    // find animal records where name contains a given string
    List<Animal> findByNameContainingIgnoreCase(String name);
}
