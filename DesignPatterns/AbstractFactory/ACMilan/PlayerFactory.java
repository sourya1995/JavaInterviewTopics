package DesignPatterns.AbstractFactory.ACMilan;

public interface PlayerFactory {
    Player createForward();
    Player createMidfielder();
    Player createDefender();
}
