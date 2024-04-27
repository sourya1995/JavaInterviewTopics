package DesignPatterns.Builder;

public class MediumOnionPizza extends VegPizza{
    @Override
    public float prices() {
        return 180.0f;
    }

    @Override
    public String name() {
        return "MediumOnionPizza";
    }

    @Override
    public String size() {
       return "Medium";
    }
}
