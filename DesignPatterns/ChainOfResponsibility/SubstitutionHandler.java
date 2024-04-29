package DesignPatterns.ChainOfResponsibility;

public interface SubstitutionHandler {
    void handleRequest(SubstitutionRequest request);
    void setNextHandler(SubstitutionHandler nextHandler);
}
