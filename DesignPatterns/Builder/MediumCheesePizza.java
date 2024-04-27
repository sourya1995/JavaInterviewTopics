package DesignPatterns.Builder;

public class MediumCheesePizza extends VegPizza {

    @Override
    public float prices() {
       return 220.0f;
    }

    @Override
    public String name() {
        return "Medium Cheese Pizza";
    }

    @Override
    public String size() {
        return "Medium";
    }
    
}
