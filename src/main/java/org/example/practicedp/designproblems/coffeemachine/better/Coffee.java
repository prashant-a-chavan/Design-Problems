package org.example.practicedp.designproblems.coffeemachine.better;


public class Coffee {
    private final CoffeeTypes coffeeType;
    private final Recipe recipe;
    private final int price;

    public Coffee(CoffeeTypes coffeeType, Recipe recipe, int price) {
        this.coffeeType = coffeeType;
        this.recipe = recipe;
        this.price = price;
    }

    boolean prepare(Inventory inventory) {
        if (!inventory.hasEnoughIngredients(recipe)) {
            String missing = inventory.getMissingIngredient(recipe);
            System.out.println("Cannot make " + coffeeType + ", insufficient " + missing);
            return false;
        }

        inventory.deductIngredients(recipe);
        return true;
    }
}
