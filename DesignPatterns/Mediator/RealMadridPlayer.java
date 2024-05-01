package DesignPatterns.Mediator;

public class RealMadridPlayer implements Player {
    private String name;
    private CoachMediator mediator;

    
    public RealMadridPlayer(String name, CoachMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addPlayer(this);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void sendMessage(String message) {
       mediator.sendMessage(this, message);
    }
    @Override
    public void receiveMessage(String message) {
       System.out.println(name + "Received message: " + message);
    }
}
