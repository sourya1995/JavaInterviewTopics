package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class OLL3 {
    private final Object ollLock = new Object();
    public void methodOll() {
        synchronized (ollLock) {
            System.out.println("methodOll");
        }
    }
}
