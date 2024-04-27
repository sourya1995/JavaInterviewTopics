package DesignPatterns.Builder;

public class LargePepsi extends Pepsi{
    @Override
    public float prices() {
        return 52.0f;
    }

    @Override
    public String name() {
        return "LargePepsi";
    }

    @Override
    public String size() {
        return "Large";
    }
}
