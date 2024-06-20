package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class OLL2 {
    public void methodOLL2() {
        synchronized (this) {
            System.out.println("OLL example");
        }
    }
}
