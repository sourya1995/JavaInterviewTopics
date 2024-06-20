package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class TerminatedThread {
    public void terminatedThread() throws InterruptedException {
        Thread t = new Thread(() -> {});
        t.start();

        Thread.sleep(2000);
        System.out.println("Terminated: " + t.getState());
    }

    public static void main(String[] args) {
        TerminatedThread t = new TerminatedThread();
        try {
            t.terminatedThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
