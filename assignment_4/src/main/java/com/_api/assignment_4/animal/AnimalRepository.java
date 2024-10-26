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

    // Native query to fetch animals with specific conditions, for example, those with non-null descriptions
    @Query(value = "select * from animal a where a.name is not null", nativeQuery = true)
    List<Animal> searchAnimalsByName(String name);
}