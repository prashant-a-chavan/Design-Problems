package org.example.practicedp.designproblems.coffeemachine.naive.coffeetypes;

public class EspressoCoffee extends Coffee{
    private static final int PRICE = 40;
    private static final int COFFEE_QUANTITY = 1;
    private static final int MILK_QUANTITY = 0;
    private static final int WATER_QUANTITY = 0;

    public EspressoCoffee() {
        super(COFFEE_QUANTITY, MILK_QUANTITY, WATER_QUANTITY, PRICE);
    }
}
