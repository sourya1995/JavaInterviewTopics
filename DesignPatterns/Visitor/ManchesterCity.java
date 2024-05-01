package DesignPatterns.Visitor;

public class ManchesterCity implements FootballTeam {
    private int totalGoalsConceded;
    private int totalGoalsScored;

    public ManchesterCity(int totalGoalsConceded, int totalGoalsScored) {
        this.totalGoalsConceded = totalGoalsConceded;
        this.totalGoalsScored = totalGoalsScored;
    }

    public int getTotalGoalsConceded() {
        return totalGoalsConceded;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    @Override
    public void accept(FootballStatisticVisitor visitor) {
        visitor.visit(this);
    }



}
