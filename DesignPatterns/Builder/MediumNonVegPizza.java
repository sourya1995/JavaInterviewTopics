package DesignPatterns.Builder;

public class MediumNonVegPizza extends NonVegPizza {

    @Override
    public float prices() {
        return 220.0f;
    }

    @Override
    public String name() {
       return "Medium Non Veg Pizza";
    }

    @Override
    public String size() {
        return "Medium";
    }
    
}
