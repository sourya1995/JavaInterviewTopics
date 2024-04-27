package DesignPatterns.Builder;

public class LargeCheesePizza extends VegPizza {

    @Override
    public float prices() {
        return 290.0f;
    }

    @Override
    public String name() {
        return "Large Cheese Pizza";
    }

    @Override
    public String size() {
       return "Large";
    }
    
}
