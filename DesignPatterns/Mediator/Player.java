package DesignPatterns.Mediator;

public interface Player {
    String getName();
    void sendMessage(String message);
    void receiveMessage(String message);
}
