package com._api.assignment_4.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com._api.assignment_4.animal.AnimalService;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */

//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * <a href="http://localhost:8080/animals/all">All</a>
     */
    @GetMapping("/all")
    //public List<Animal> getAllAnimals() {
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        // return service.getAllAnimals();
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * <a href="http://localhost:8080/animals/2">One</a>
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
    }

    /**
     * Get a list of Animals based on their class.
     * <a href="http://localhost:8080/animals?class=mammal">...</a>
     *
     * @param animalClass the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("")
    //@GetMapping("class/{animalClass}")
    public String getAnimalsByClass(@RequestParam(name = "class", defaultValue = "mammal") String animalClass, Model model) {
        model.addAttribute("animalList", service.getAnimalsByClass(animalClass));
        model.addAttribute("title", "Animal Class: " +animalClass);
        return "animal-list";
    }

    /**
     * Search for Animals whose name contains a string.
     * <a href="http://localhost:8080/animals/search?name=blue">...</a>
     *
     * @param name the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam(name = "name", defaultValue = "bird") String name, Model model) {
        model.addAttribute("animalList", service.searchAnimalsByName(name));
        model.addAttribute("title", "Animals:"+name);
        //return service.searchAnimalsByName(name);
        return "animal-list";
    }

    /**
     * Create a new Animal entry.
     * <a href="http://localhost:8080/animals/new">...</a> --data '{ "name": "Blue Jay", "scientificName": "Cyanocitta cristata", "animalClass": "Aves", "habitat": "Forests", "description": "A blue bird." }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        service.saveAnimal(animal);
        return "redirect:animals/all";
    }

    /**
     * Show the update form.
     * @param animalId the unique Animal ID.
     * @param model the new updated Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }

    /**
     * Perform the update.
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.saveAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    /**
     * Delete an Animal object.
     * <a href="http://localhost:8080/animals/delete/2">Delete One</a>
     *
     * @param animalId the unique Animal ID.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return "redirect:/animals/all";
    }
}