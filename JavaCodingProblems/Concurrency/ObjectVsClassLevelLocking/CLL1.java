package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class CLL1 {
    public synchronized static void m1() {
        System.out.println("whatever");
    }
}
