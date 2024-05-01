package DesignPatterns.Visitor;

public class GoalsConcededVisitor implements FootballStatisticVisitor {

    private int totalGoalsConceded = 0;

    public int getTotalGoalsConceded() {
        return totalGoalsConceded;
    }

    @Override
    public void visit(ManchesterCity manCity) {
       
       totalGoalsConceded += manCity.getTotalGoalsConceded();
    }
    
}
