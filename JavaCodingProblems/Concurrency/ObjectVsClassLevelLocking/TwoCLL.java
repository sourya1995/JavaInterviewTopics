package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class TwoCLL {
    public synchronized static void StaticMethod() {
        System.out.println("StaticMethod:" + Thread.currentThread().getName());
        while(true){}
    }

    public synchronized static void staticMethod() {
        System.out.println("StaticMethod:" + Thread.currentThread().getName());
        while(true) {}
    }
}
/*Two threads running will not execute concurrently because one thread acquires a class level lock. So only one static method 
 * will run using one thread
  */