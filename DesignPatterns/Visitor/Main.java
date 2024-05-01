package DesignPatterns.Visitor;

public class Main {
    public static void main(String[] args) {
        ManchesterCity manCity = new ManchesterCity(90, 30);

        GoalsScoredVisitor goalsScoredVisitor = new GoalsScoredVisitor();
        manCity.accept(goalsScoredVisitor);

        GoalsConcededVisitor goalsAgainstVisitor = new GoalsConcededVisitor();
        manCity.accept(goalsAgainstVisitor);

        System.out.println(goalsScoredVisitor.getTotalGoalsScored());
        System.out.println(goalsAgainstVisitor.getTotalGoalsConceded());

    }
}
