package DesignPatterns.Builder;

public class SmallOnionPizza extends VegPizza {

    @Override
    public float prices() {
        return 140.0f;
    }

    @Override
    public String name() {
        return "SmallOnionPizza";
    }

    @Override
    public String size() {
       return "Small";
    }
    
}
