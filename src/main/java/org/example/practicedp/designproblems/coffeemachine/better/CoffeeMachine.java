package org.example.practicedp.designproblems.coffeemachine.better;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner sc = new Scanner(System.in);
    public static final String EXIT_CODE = "0";
    public static final String REFILL_CODE = "1";

    public void start() {
        Inventory inventory = new Inventory();

        while(true) {
            String choice = showMenuAndGetChoice();

            if (choice.equals(EXIT_CODE)) break;
            if (choice.equals(REFILL_CODE)) {
                inventory.refillIngredients();
                System.out.println(inventory);
                continue;
            }

            handleCoffeePreparation(choice, inventory);
        }
        System.out.println("Thank you! Visit again...");
    }

    private static String showMenuAndGetChoice() {
        System.out.println("\nCoffee Types: ");
        for (CoffeeTypes type : CoffeeTypes.values()) {
            System.out.println(type);
        }
        System.out.println("1. Refill Ingredients");
        System.out.println("0. Exit");
        System.out.print("Enter coffee type: ");

        return sc.nextLine();
    }

    private static void handleCoffeePreparation(String choice, Inventory inventory) {
        if (Arrays.stream(CoffeeTypes.values()).anyMatch(coffeeTypes -> coffeeTypes.name().equalsIgnoreCase(choice))) {
            Coffee coffee = switch (CoffeeTypes.valueOf(choice.toUpperCase())) {
                case ESPRESSO -> CoffeeFactory.createEspresso();
                case LATTE -> CoffeeFactory.createLatte();
                case CAPPUCCINO -> CoffeeFactory.createCappuccino();
            };

            if(coffee.prepare(inventory)) {
                System.out.println(choice + " prepared! Enjoy your coffee.");
                System.out.println("Remaining: " + inventory);
            }
        } else {
            System.out.println("Invalid input!");
        }
    }
}
