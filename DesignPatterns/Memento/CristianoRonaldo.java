package DesignPatterns.Memento;

public class CristianoRonaldo {
    private int goals;
    private int assists;

    public void scoreGoal() {
        goals++;
    }

    public void provideAssist() {
        assists++;
    }

    public MatchPerformanceMemento saveMatchPerformance() {
        return new MatchPerformanceMemento(goals, assists);
    }

    public void restoreMatchPerformance(MatchPerformanceMemento matchPerformanceMemento) { 
        this.goals = matchPerformanceMemento.getGoals();
        this.assists = matchPerformanceMemento.getAssists();
    }

    public void displayMatchPerformance() {
        System.out.println("Goals scored:" + goals);
        System.out.println("assists provided:" + assists);
    }


}
