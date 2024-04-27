package DesignPatterns.Builder;

public class LargeCoke extends Coke{
    @Override
    public float prices() {
        return 55.0f;
    }

    @Override
    public String name() {
        return "LargeCoke";
    }

    @Override
    public String size() {
        return "Large";
    }
}
