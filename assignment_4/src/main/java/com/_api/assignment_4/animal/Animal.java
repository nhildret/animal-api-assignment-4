package com._api.assignment_4.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String scientificName;

    @Column(nullable = false)
    private String animalClass;

    @Column(nullable = false)
    private String habitat;

    @Column(nullable = true)
    private String description;

    public Animal(String name, String scientificName, String animalClass, String habitat, String description) {
        this.name = name;
        this.scientificName = scientificName;
        this.animalClass = animalClass;
        this.habitat = habitat;
        this.description = description;
    }

    public Animal() {
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAnimalClass() { return animalClass; }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getHabitat() { return habitat ; }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDescription() { return description ; }

    public void setDescription(String description) {
        this.description = description;
    }

}
