package DesignPatterns.ChainOfResponsibility;

public class AssistantCoach implements SubstitutionHandler {
    private SubstitutionHandler nextHandler;

    public void setNextHandler(SubstitutionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SubstitutionRequest request) {
        if(request.getInjuredPlayer().equals("Hristo Stoichkov")){
            System.out.println("Stoichkov injured." + request.getSubstitutePlayer());
        } else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
    
}
