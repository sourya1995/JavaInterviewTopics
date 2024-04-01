package Concurrency.Synchronized;

public class Shared {
    int i;

    synchronized void SharedMethod() {
        Thread t = Thread.currentThread();
        System.err.println(t);
        for (int i = 0; i <= 1000; i++){
            System.out.println(t.getName() + ": " + i);
        }
    }

    void SharedMethod2() {
        synchronized(this){
            System.out.println("Some really unique stuff" + this);
        }
    }
}
