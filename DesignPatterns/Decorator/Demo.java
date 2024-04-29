package DesignPatterns.Decorator;

public class Demo {
    public static void main(String[] args) {
        Food f1 = new NonVegFood(new VegFood());
        f1.foodPrices();
        f1.prepareFood();
    }
}
