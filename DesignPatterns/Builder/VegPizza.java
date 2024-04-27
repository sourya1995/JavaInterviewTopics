package DesignPatterns.Builder;

public abstract class VegPizza extends Pizza {
    
    @Override
    public abstract float prices();

    @Override
    public abstract String name();

    @Override
    public abstract String size();
}
