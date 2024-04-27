package DesignPatterns.AbstractFactory.ACMilan;

public class Main {
    public static void main(String[] args) {
        PlayerFactory playerFactory = new MilanPlayerFactory();
        Player forward = playerFactory.createForward();
        Player defender = playerFactory.createDefender();
        Player midfielder = playerFactory.createMidfielder();
       

        forward.displayInfo();
        defender.displayInfo();
        midfielder.displayInfo();
    }
}
