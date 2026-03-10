package org.example.practicedp.designproblems.coffeemachine.naive;

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
}
