package com._api.assignment_4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for Animal objects.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // Custom query to get animals by their class
    List<Animal> findByAnimalClass(String animalClass);

    // Custom query to get animals whose name contains a specific string
    List<Animal> findByNameContainingIgnoreCase(String name);

    // Native query to fetch animals with specific conditions, for example, those with non-null descriptions
    @Query(value = "SELECT * FROM animal WHERE description IS NOT NULL", nativeQuery = true)
    List<Animal> findAnimalsWithDescriptions();
}