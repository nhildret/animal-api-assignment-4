package com._api.assignment_4.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() { return service.getAllAnimals(); }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) { return service.getAnimalById(animalId) ; }

    /**
     * Get a list of Animals based on their class.
     * http://localhost:8080/animals/class/mammal
     *
     * @param animalClass the search key.
     * @return A list of Animal objects matching the search key.
     */

    @GetMapping("class/{animalClass}")
    public List<Animal> getAnimalsByClass(@PathVariable String animalClass) {
        return service.getAnimalsByClass(animalClass);
    }

    /**
     * Search for Animals whose name contains a string.
     * http://localhost:8080/animals/search?name=blue
     *
     * @param name the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam(name = "name") String name) {
        return service.searchAnimalsByName(name);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{ "name": "Blue Jay", "scientificName": "Cyanocitta cristata", "animalClass": "Aves", "habitat": "Forests", "description": "A blue bird." }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public Animal addNewAnimal(@RequestBody Animal animal) {
        return service.saveAnimal(animal);
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "name": "Updated Animal", "scientificName": "Updated Name", "animalClass": "Mammalia", "habitat": "Savannah", "description": "An updated description." }'
     *
     * @param animalId the unique Animal ID.
     * @param animal   the new updated Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        return service.updateAnimal(animalId, animal);
    }

    /**
     * Delete an Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal ID.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return service.getAllAnimals();
    }
}