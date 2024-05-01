package DesignPatterns.Visitor;

public class GoalsScoredVisitor implements FootballStatisticVisitor {

    private int totalGoalsScored = 0;

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }


    @Override
    public void visit(ManchesterCity manCity) {
      totalGoalsScored += manCity.getTotalGoalsScored();
    }
    
}
