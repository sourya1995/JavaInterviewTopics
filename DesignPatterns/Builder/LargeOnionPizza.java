package DesignPatterns.Builder;

public class LargeOnionPizza extends VegPizza{
    @Override
    public float prices() {
        return 190.0f;
    }

    @Override
    public String name() {
        return "LargeOnionPizza";
    }

    @Override
    public String size() {
       return "Large";
    }
}
