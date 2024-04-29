package DesignPatterns.Decorator;

public class ChineseFood extends FoodDecorator {

    public ChineseFood(Food newFood) {
        super(newFood);
        //TODO Auto-generated constructor stub
    }

    public String prepareFood(){
        return super.prepareFood() + "some stuff";
    }

    @Override
    public double foodPrices(){
        return super.foodPrices() + 2;
    }
    
}
