package org.example.practicedp.designproblems.coffeemachine.naive;

public class CoffeeMachine {
//    private Map<Map<CoffeeTypes, Integer>, Map<Ingrediants, Integer>> coffeeTypesListMap = new HashMap<>();
//
//    public void start() {
//        System.out.println("Coffee machine started");
//
//        // ESPRESSO
//        coffeeTypesListMap = setupCoffee(CoffeeTypes.ESPRESSO, 40,1, 0, 0);
//
//        // LATTE
//        coffeeTypesListMap = setupCoffee(CoffeeTypes.LATTE, 60, 1, 1, 1);
//
//        // CAPPUCCINO
//        coffeeTypesListMap = setupCoffee(CoffeeTypes.CAPPUCCINO, 70,1, 2, 1);
//
//        System.out.println(coffeeTypesListMap);
//    }
//
//    private Map<Map<CoffeeTypes, Integer>, Map<Ingrediants, Integer>> setupCoffee(CoffeeTypes type, int price, int coffeeQuantity, int milkQuantity, int waterQuantity) {
//        Map<Ingrediants, Integer> ingredients = new EnumMap<>(Ingrediants.class);
//        ingredients.put(Ingrediants.COFFEE, coffeeQuantity);
//        ingredients.put(Ingrediants.MILK, milkQuantity);
//        ingredients.put(Ingrediants.WATER, waterQuantity);
//
//        coffeeTypesListMap.put(Map.of(type, price), ingredients);
//        return coffeeTypesListMap;
//    }



    public void start() {
        System.out.println("Starting Coffee Machine");
    }
}
