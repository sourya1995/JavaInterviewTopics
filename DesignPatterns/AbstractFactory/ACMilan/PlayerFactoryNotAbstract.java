package DesignPatterns.AbstractFactory.ACMilan;

public class PlayerFactoryNotAbstract {
    public Player createPlayer(String type) {
        switch(type.toLowerCase()){
            case "forward":
                return new Forward();
            case "midfielder":
                return new Midfielder();
            case "defender":
                return new Defender();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
