package DesignPatterns.Builder;

public class MediumPepsi extends Pepsi {
    @Override
    public float prices() {
        return 38.0f;
    }

    @Override
    public String name() {
        return "MediumPepsi";
    }

    @Override
    public String size() {
        return "Medium";
    }
}
