package crudapi.example.animal_api.controller;

import crudapi.example.animal_api.model.Animal;
import crudapi.example.animal_api.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animal")
public class AnimalApiController {

    private final AnimalService animalService;

    @Autowired
    public AnimalApiController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Gets all animals (API)
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // Gets animal by ID (API)
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adds a new animal (API)
    @PostMapping("/new")
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // Updates an existing animal (API)
    @PutMapping("/update/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animalDetails) {
        Optional<Animal> updatedAnimal = animalService.updateAnimal(id, animalDetails);
        return updatedAnimal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletes an animal (API)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        if (animalService.deleteAnimal(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Gets animals by species (API)
    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // Searches animals by name (API)
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}
