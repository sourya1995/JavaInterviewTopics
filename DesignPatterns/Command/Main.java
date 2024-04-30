package DesignPatterns.Command;

public class Main {
    public static void main(String[] args) {
        BayernMunichTeam team = new BayernMunichTeam();

        Command attackCommand = new AttackCommand(team);
        Command defendCommand = new DefendCommand(team);

        Coach coach = new Coach();
        coach.setCommand(attackCommand);
        coach.executeStrategy();

        coach.setCommand(defendCommand);
        coach.executeStrategy();

    }
}
