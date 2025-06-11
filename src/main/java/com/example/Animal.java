package com.example;

import java.util.List;

public class Animal {

    public List<Food> getFood(AnimalKind animal) throws Exception {
        if (animal == AnimalKind.Herbivore) {
            return List.of(Food.Grass, Food.VariousPlants);
        } else if (animal == AnimalKind.Predator) {
            return List.of(Food.Animals, Food.Birds, Food.Fish);
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    public Family getFamily() throws Exception {
        throw new UnsupportedOperationException("Необходимо возвращать семейство");
    }
}