package crudapi.example.animal_api.controller;

import crudapi.example.animal_api.model.Animal;
import crudapi.example.animal_api.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // gets all animals
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // gets animal by ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // adds a new animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // updates an existing animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animalDetails) {
        Optional<Animal> updatedAnimal = animalService.updateAnimal(id, animalDetails);
        return updatedAnimal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // deletes an animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        if (animalService.deleteAnimal(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // gets all animals of a given species
    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // gets animals whose name contains a string
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}
