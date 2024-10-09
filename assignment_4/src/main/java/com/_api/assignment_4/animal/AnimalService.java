package com._api.assignment_4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Student Database.
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique Animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose class matches the search term.
     *
     * @param animalClass the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByClass(String animalClass) {
        return animalRepository.findByAnimalClass(animalClass);
    }

    /**
     * Search for Animals whose name contains a string.
     *
     * @param name the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new Animal details.
     */
    public Animal updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        if (existing != null) {
            existing.setName(animal.getName());
            existing.setScientificName(animal.getScientificName());
            existing.setAnimalClass(animal.getAnimalClass());
            existing.setHabitat(animal.getHabitat());
            existing.setDescription(animal.getDescription());

            return animalRepository.save(existing); // Save and return updated entity
        }
        return null; // Or throw an exception if not found
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal Id.
     */
    public void deleteAnimal(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
