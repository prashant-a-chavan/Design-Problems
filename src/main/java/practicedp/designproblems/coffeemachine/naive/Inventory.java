package practicedp.designproblems.coffeemachine.naive;

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

    public int getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }
}
