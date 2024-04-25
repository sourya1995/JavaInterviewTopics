package DesignPatterns.Strategy;

public class Multiplication implements Strategy {

    @Override
    public float calculation(float x, float y) {
       return x * y;
    }
    
}
