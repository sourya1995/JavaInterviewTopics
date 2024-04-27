package DesignPatterns.Builder;

public class SmallNonVegPizza extends NonVegPizza{

    @Override
    public float prices() {
        return 190.0f;
    }

    @Override
    public String name() {
       return "Small Non Veg Pizza";"
    }

    @Override
    public String size() {
       return "Small";
    }
    
}
