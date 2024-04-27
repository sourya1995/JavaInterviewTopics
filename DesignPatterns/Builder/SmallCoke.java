package DesignPatterns.Builder;

public class SmallCoke extends Coke {
    @Override
    public float prices() {
        return 27.0f;
    }

    @Override
    public String name() {
        return "SmallCoke";
    }

    @Override
    public String size() {
        return "Small";
    }
}
