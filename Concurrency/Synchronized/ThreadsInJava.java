package Concurrency.Synchronized;

public class ThreadsInJava {
    public static void main(String[] args) {
        final Shared s1 = new Shared();
        Thread t1 = new Thread("Thread - 1"){
            @Override
            public void run() {
                s1.SharedMethod();
            }
        };

        Thread t2 = new Thread("Thread - 2"){
            @Override
            public void run() {
                s1.SharedMethod();
            }
        };

        t1.start();
        t2.start();
    }
}
