package DesignPatterns.TemplateMethod;

public class Chess extends Game {

    @Override
    void initialize() {
       System.out.println("Chess game initialized");
    }

    @Override
    void start() {
      System.out.println("Game started"); 
    }

    @Override
    void end() {
       System.out.println("Game ended");
    }
    
}
