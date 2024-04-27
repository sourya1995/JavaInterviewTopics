package DesignPatterns.Builder;

public class ExtraLargeMasalaPizza extends VegPizza {
    @Override
    public float prices() {
        return 190.0f;
    }

    @Override
    public String name() {
        return "Extra Large Masala Pizza";
    }

    @Override
    public String size() {
       return "Extra Large";
    }
}
