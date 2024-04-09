package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void onAction(String a);
}

interface Observable {
    public abstract List<Observer> getObservers();
    
    public default void addObserver(Observer o) {
        getObservers().add(o);
    }
    
    public default void removeObserver(Observer o) {
        getObservers().remove(o);
    }

    public default void notify(String a) {
        for (Observer o : getObservers()) { //TODO
            o.onAction(a);
        }
    }
}

abstract class Worker {
    public abstract void work();
}

public class MyWorker extends Worker implements Observable {

    private List<Observer> myObservers = new ArrayList<Observer>();
    

    @Override
    public List<Observer> getObservers() {
        
        return myObservers;
    }

    @Override
    public void work() {
      notify("started");
      //some work
      notify("completed");
    }

    public static void main(String[] args) {
        MyWorker myWorker = new MyWorker();
        
        myWorker.addObserver(new Observer() {
            @Override
            public void onAction(String a) {
                System.out.println("soething"); //do something
            }
        });
        
        myWorker.work();
    }
    
    
}
