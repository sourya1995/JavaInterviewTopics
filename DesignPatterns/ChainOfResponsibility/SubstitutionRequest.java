package DesignPatterns.ChainOfResponsibility;

public class SubstitutionRequest {
    private String injuredPlayer;
    private String substitutePlayer;
    public SubstitutionRequest(String injuredPlayer, String substitutePlayer) {
        this.injuredPlayer = injuredPlayer;
        this.substitutePlayer = substitutePlayer;
    }

    public String getInjuredPlayer() {
        return injuredPlayer;
    }

    public String getSubstitutePlayer() {
        return substitutePlayer;
    }
}
