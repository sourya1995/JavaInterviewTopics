package DesignPatterns.Strategy;

public class Subtraction implements Strategy {

    @Override
    public float calculation(float x, float y) {
        return x - y;
    }
    
}
