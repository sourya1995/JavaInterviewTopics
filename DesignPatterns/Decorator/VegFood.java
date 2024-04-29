package DesignPatterns.Decorator;

public class VegFood implements Food {

    @Override
    public String prepareFood() {
       return "Veg Food";
    }

    @Override
    public double foodPrices() {
        return 60.0;
    }
    
}
