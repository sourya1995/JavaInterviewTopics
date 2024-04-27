package DesignPatterns.Builder;

public class SmallCheesePizza extends VegPizza {

    @Override
    public float prices() {
        return 180.0f;
    }

    @Override
    public String name() {
       return "Small Cheese Pizza";
    }

    @Override
    public String size() {
        return "Small";
    }
    
}
