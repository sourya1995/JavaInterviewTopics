package DesignPatterns.ChainOfResponsibility;

public class TeamCaptain implements SubstitutionHandler {

    private SubstitutionHandler nextHandler;

    public void setNextHandler(SubstitutionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SubstitutionRequest request) {
       System.out.println("I take final decision");
    }
    
}
