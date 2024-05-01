package DesignPatterns.Memento;

import java.util.ArrayList;
import java.util.List;

public class MatchPerformanceCaretaker {
    private List<MatchPerformanceMemento> mementos = new ArrayList<>();

    public void addMemento(MatchPerformanceMemento memento) {
        mementos.add(memento);
    }

    public MatchPerformanceMemento getMemento(int index){
        return mementos.get(index);
    }
    
}
