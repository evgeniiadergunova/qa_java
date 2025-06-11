package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline feline;

    public Lion(Sex sex, Feline feline) throws Exception {
        if (sex == Sex.MALE) {
            hasMane = true;
        } else if (sex == Sex.FEMALE) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
        this.feline = feline;

    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<Food> getFood() throws Exception {
        return feline.getFood(AnimalKind.Predator);
    }
}
