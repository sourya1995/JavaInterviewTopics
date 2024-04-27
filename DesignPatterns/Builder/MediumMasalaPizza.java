package DesignPatterns.Builder;

public class MediumMasalaPizza extends VegPizza {
    @Override
    public float prices() {
        return 130.0f;
    }

    @Override
    public String name() {
        return "MediumMasalaPizza";
    }

    @Override
    public String size() {
       return "Medium";
    }
}
