package DesignPatterns.AbstractFactory.ACMilan;

public interface PlayerFactory {
    Player createForward();
    Player createMidfielder();
    Player createDefender();
}
 //in abstract factory, create an interface of methods first