package DesignPatterns.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        SubstitutionHandler captain = new TeamCaptain();
        SubstitutionHandler assistantCoach = new AssistantCoach();
        SubstitutionHandler coach = new Coach();
        assistantCoach.setNextHandler(captain);
        coach.setNextHandler(assistantCoach);

        SubstitutionRequest request = new SubstitutionRequest("Lionel Messi", "Antoine Griezmann");
        coach.handleRequest(request);
    }
}
