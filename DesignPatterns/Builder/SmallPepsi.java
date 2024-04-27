package DesignPatterns.Builder;

public class SmallPepsi extends Pepsi {

    @Override
    public float prices() {
        return 27.0f;
    }

    @Override
    public String name() {
        return "SmallPepsi";
    }

    @Override
    public String size() {
        return "Small";
    }
    
}
