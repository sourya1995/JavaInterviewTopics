package DesignPatterns.Builder;

public class ExtraLargeCheesePizza extends VegPizza{

    @Override
    public float prices() {
        return 320.0f;
    }

    @Override
    public String name() {
        return "Extra Large Cheese Pizza";
    }

    @Override
    public String size() {
        return "Extra Large";
    }
    
}
