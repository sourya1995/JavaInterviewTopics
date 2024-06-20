package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class CLL3 {
    private final static Object lock = new Object();
    public void method(){
        synchronized (lock){
            //do something
        }
    }

}
