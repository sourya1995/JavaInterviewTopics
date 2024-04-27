package DesignPatterns.Builder;

public class LargeMasalaPizza extends VegPizza{
    @Override
    public float prices() {
        return 170.0f;
    }

    @Override
    public String name() {
        return "Large Masala Pizza";
    }

    @Override
    public String size() {
       return "Large";
    }
}
