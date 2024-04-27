package DesignPatterns.AbstractFactory.ACMilan;

public class MilanPlayerFactory implements PlayerFactory {

    @Override
    public Player createForward() {
        return new Forward();
    }

    @Override
    public Player createMidfielder() {
       return new Midfielder();
    }

    @Override
    public Player createDefender() {
       return new Defender();
    }
    
}
