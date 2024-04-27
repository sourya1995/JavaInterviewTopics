package DesignPatterns.Builder;

public class ExtraLargeOnionPizza extends VegPizza{
    @Override
    public float prices() {
        return 220.0f;
    }

    @Override
    public String name() {
        return "ExtraLargeOnionPizza";
    }

    @Override
    public String size() {
       return "Extra Large";
    }
}
