package org.example.practicedp.designproblems.coffeemachine.naive.coffeetypes;

import org.example.practicedp.designproblems.coffeemachine.naive.Inventory;

abstract class Coffee {
    int coffeeQuantity = 0;
    int milkQuantity = 0;
    int waterQuantity = 0;
    int price = 0;

    protected Coffee(int coffeeQuantity, int milkQuantity, int waterQuantity, int price) {
        this.coffeeQuantity = coffeeQuantity;
        this.milkQuantity = milkQuantity;
        this.waterQuantity = waterQuantity;
        this.price = price;
    }

    void prepare(Inventory inventory) {
        System.out.println("Preparing Coffee");
        if (inventory.getCoffeeQuantity() < this.coffeeQuantity) {
            System.out.println("Sorry, not enough coffee left!");
            return;
        }

        if (inventory.getMilkQuantity() < this.milkQuantity) {
            System.out.println("Sorry, not enough milk left!");
            return;
        }

        if (inventory.getWaterQuantity() < this.waterQuantity) {
            System.out.println("Sorry, not enough water left!");
            return;
        }

        inventory.setCoffeeQuantity(inventory.getCoffeeQuantity() - this.coffeeQuantity);
        inventory.setMilkQuantity(inventory.getMilkQuantity() - this.milkQuantity);
        inventory.setWaterQuantity(inventory.getWaterQuantity() - this.waterQuantity);
        System.out.println("Your Coffee is ready!!!");
    }
}
