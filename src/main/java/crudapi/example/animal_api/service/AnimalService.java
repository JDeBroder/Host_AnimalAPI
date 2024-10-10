package crudapi.example.animal_api.service;

import crudapi.example.animal_api.model.Animal;
import crudapi.example.animal_api.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // gets all animals
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // gets animal by ID
    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    // adds a new animal
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    // updates an existing animal
    public Optional<Animal> updateAnimal(int id, Animal animalDetails) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(animalDetails.getName());
            animal.setScientificName(animalDetails.getScientificName());
            animal.setSpecies(animalDetails.getSpecies());
            animal.setHabitat(animalDetails.getHabitat());
            animal.setDescription(animalDetails.getDescription());
            return animalRepository.save(animal);
        });
    }

    // deletes an animal
    public boolean deleteAnimal(int id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // gets animals by species
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    // gets animals whose name contains a string
    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }
}
