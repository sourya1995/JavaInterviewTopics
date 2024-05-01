package DesignPatterns.Memento;

public class MatchPerformanceMemento {
    private int goals;
    private int assists;
    public MatchPerformanceMemento(int goals, int assists) {
        this.goals = goals;
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }
}
