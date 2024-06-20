package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class TwoSyncs {

    public synchronized void method1() {
        System.out.println("method1(): " + Thread.currentThread().getName());
        method2(); /*this is legal because synchronized is RE-ENTRANT - same lock is used for both methods - same 
        thread enters another method in the same object*/
    }

    public synchronized void method2() {
        System.out.println("method2(): " + Thread.currentThread().getName());
        while (true) {
        }
    }
}