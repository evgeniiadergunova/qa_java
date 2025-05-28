package com.example;

import java.util.List;

public class Feline extends Animal implements Predator {

    @Override
    public List<Food> eatMeat() throws Exception {
        return getFood(AnimalKind.Predator);
    }

    @Override
    public Family getFamily() {
        return Family.Feline;
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
