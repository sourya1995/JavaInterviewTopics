package DesignPatterns.Strategy;

public class Addition implements Strategy  {

    @Override
    public float calculation(float x, float y) {
       return x + y;
    }
    
}
