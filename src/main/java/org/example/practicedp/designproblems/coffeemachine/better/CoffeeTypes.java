package org.example.practicedp.designproblems.coffeemachine.better;

public enum CoffeeTypes {
    ESPRESSO("Espresso"), LATTE("Latte"), CAPPUCCINO("Cappuccino");

    private final String name;

    CoffeeTypes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
