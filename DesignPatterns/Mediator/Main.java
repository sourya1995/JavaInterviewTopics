package DesignPatterns.Mediator;

public class Main {
    public static void main(String[] args) {
        HeadCoach headCoach = new HeadCoach();

        // Create Real Madrid players (colleagues)
        Player ramos = new RealMadridPlayer("Sergio Ramos", headCoach);
        Player benzema = new RealMadridPlayer("Karim Benzema", headCoach);
        Player modric = new RealMadridPlayer("Luka Modric", headCoach);

        // Send messages between players through the mediator
        ramos.sendMessage("Let's practice free kicks after training.");
        benzema.sendMessage("Sure, I'll join you. Modric, are you in?");
        modric.sendMessage("I'll be there too!");
    }
}
