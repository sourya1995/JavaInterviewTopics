package DesignPatterns.Builder;

public class ExtraLargeNonVegPizza extends NonVegPizza {
    @Override
    public float prices() {
        return 260.0f;
    }

    @Override
    public String name() {
       return "Extra Large Non Veg Pizza";
    }

    @Override
    public String size() {
        return "Extra Large";
    }
}
