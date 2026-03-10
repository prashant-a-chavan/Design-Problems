package org.example.practicedp.designproblems.coffeemachine.better;

public class CoffeeFactory {

    private CoffeeFactory() {}
    public static Coffee createEspresso() {
        Recipe recipe = new Recipe(1, 0, 0);
        return new Coffee(CoffeeTypes.ESPRESSO, recipe, 40);
    }

    public static Coffee createLatte() {
        Recipe recipe = new Recipe(1, 1, 1);
        return new Coffee(CoffeeTypes.LATTE, recipe, 60);
    }

    public static Coffee createCappuccino() {
        Recipe recipe = new Recipe(1, 2, 1);
        return new Coffee(CoffeeTypes.CAPPUCCINO, recipe, 70);
    }
}
