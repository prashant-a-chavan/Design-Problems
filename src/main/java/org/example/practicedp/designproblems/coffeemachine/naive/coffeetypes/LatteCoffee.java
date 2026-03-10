package org.example.practicedp.designproblems.coffeemachine.naive.coffeetypes;

public class LatteCoffee extends Coffee{
    private static final int PRICE = 60;
    private static final int COFFEE_QUANTITY = 1;
    private static final int MILK_QUANTITY = 1;
    private static final int WATER_QUANTITY = 1;

    public LatteCoffee() {
        super(COFFEE_QUANTITY, MILK_QUANTITY, WATER_QUANTITY, PRICE);
    }
}
