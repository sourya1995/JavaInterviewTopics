package DesignPatterns.ChainOfResponsibility;

public class Coach implements SubstitutionHandler {

    private SubstitutionHandler nextHandler;

    public void setNextHandler(SubstitutionHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(SubstitutionRequest request) {
        if(request.getInjuredPlayer().equals("Lionel Messi")){
            System.out.println("Messi injured." + request.getSubstitutePlayer());
        } else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
    
}
