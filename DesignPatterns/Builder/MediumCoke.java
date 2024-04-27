package DesignPatterns.Builder;

public class MediumCoke extends Coke {
    @Override
    public float prices() {
        return 38.0f;
    }

    @Override
    public String name() {
        return "MediumCoke";
    }

    @Override
    public String size() {
        return "Medium";
    }
}
