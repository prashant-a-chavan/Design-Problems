package org.example.practicedp.designproblems.coffeemachine.better;

import lombok.Data;

@Data
public class Inventory {
    private int coffeeQuantity;
    private int milkQuantity;
    private int waterQuantity;

    public Inventory() {
        this.coffeeQuantity = 10;
        this.milkQuantity = 10;
        this.waterQuantity = 10;
    }

    public void refillIngredients() {
        this.coffeeQuantity += 10;
        this.milkQuantity += 10;
        this.waterQuantity += 10;
    }

    @Override
    public String toString() {
        return "Coffee=" + coffeeQuantity + ", Milk=" + milkQuantity + ", Water=" + waterQuantity;
    }

    public boolean hasEnoughIngredients(Recipe recipe) {
        return this.coffeeQuantity >= recipe.coffeeQuantity()
            && this.milkQuantity >= recipe.milkQuantity()
            && this.waterQuantity >= recipe.waterQuantity();
    }

    public String getMissingIngredient(Recipe recipe) {
        if (coffeeQuantity < recipe.coffeeQuantity()) return "Coffee";
        if (milkQuantity < recipe.milkQuantity()) return "Milk";
        return "Water";
    }

    public void deductIngredients(Recipe recipe) {
        this.coffeeQuantity -= recipe.coffeeQuantity();
        this.milkQuantity -= recipe.milkQuantity();
        this.waterQuantity -= recipe.waterQuantity();
    }
}
