package DesignPatterns.Memento;

public class Main {
    public static void main(String[] args) {
        CristianoRonaldo ronaldo = new CristianoRonaldo();
        MatchPerformanceCaretaker careTaker = new MatchPerformanceCaretaker();

        ronaldo.scoreGoal();
        ronaldo.provideAssist();
        ronaldo.scoreGoal();

        careTaker.addMemento(ronaldo.saveMatchPerformance());

        ronaldo.displayMatchPerformance();

        MatchPerformanceMemento previousPerformance = careTaker.getMemento(0);
        ronaldo.restoreMatchPerformance(previousPerformance);
    }
}
