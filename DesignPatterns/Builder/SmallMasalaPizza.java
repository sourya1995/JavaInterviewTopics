package DesignPatterns.Builder;

public class SmallMasalaPizza extends VegPizza {
    @Override
    public float prices() {
        return 120.0f;
    }

    @Override
    public String name() {
        return "SmallMasalaPizza";
    }

    @Override
    public String size() {
       return "Small";
    }
}
