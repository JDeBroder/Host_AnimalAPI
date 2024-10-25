package crudapi.example.animal_api.controller;

import crudapi.example.animal_api.model.Animal;
import crudapi.example.animal_api.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    @PostMapping("/create")
    public String createAnimal(@ModelAttribute Animal animal) {
        animalService.addAnimal(animal);
        return "redirect:/animals";
    }




    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal.get());
            return "animal-details";
        } else {
            return "error-page";
        }
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (animal.isPresent()) {
            model.addAttribute("animal", animal.get());
            return "animal-update";
        } else {
            return "error-page";
        }
    }

    @PostMapping("/update/{id}")
    public String updateAnimal(@PathVariable int id, @ModelAttribute Animal animalDetails) {
        animalService.updateAnimal(id, animalDetails);
        return "redirect:/animals";
    }

    // Handle deleting an animal (HTML View)
    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }
    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam String name, Model model) {
        List<Animal> animals = animalService.searchAnimalsByName(name);
        model.addAttribute("animals", animals);
        model.addAttribute("title", "Search Results for: " + name);
        return "animal-list";
    }

}
