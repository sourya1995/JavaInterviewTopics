package DesignPatterns.Strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class StrategyPatternDemo {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first value");
        float value1 = Float.parseFloat(reader.readLine());
        System.out.println("Enter second value");
        float value2 = Float.parseFloat(reader.readLine());
        Context context = new Context(new Addition());
        System.out.println("The Addiiton is: " + context.executeStrategy(value1, value2));
        context = new Context(new Subtraction());
        System.out.println("The Subtraction is: " + context.executeStrategy(value1, value2));
        context = new Context(new Multiplication());
        System.out.println("The Multiplication is: " + context.executeStrategy(value1, value2));

    }
}
