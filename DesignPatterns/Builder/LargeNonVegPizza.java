package DesignPatterns.Builder;

public class LargeNonVegPizza extends NonVegPizza{
    @Override
    public float prices() {
        return 230.0f;
    }

    @Override
    public String name() {
       return "Latge Non Veg Pizza";
    }

    @Override
    public String size() {
        return "Large";
    }
}
