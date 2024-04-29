package DesignPatterns.Decorator;

public class NonVegFood extends FoodDecorator {

    public NonVegFood(Food newFood) {
        super(newFood);
    }
    
    public String prepareFood(){
        return super.prepareFood();
    }

    public double foodPrices(){
        return super.foodPrices();
    }
}
