package DesignPatterns.TemplateMethod;

public class Football extends Game {

    @Override
    void initialize() {
        System.out.println("The atmosphere is banging innit");
    }

    @Override
    void start() {
       System.out.println("Champions League music be peng doe");
    }

    @Override
    void end() {
       System.out.println("oi ref, surely not the final whistle!");
    }
    
}
