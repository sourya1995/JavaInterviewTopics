package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class TimedWaitingThread {
    public void timedWaitingThread() throws InterruptedException {
        Thread t;
        t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        });

        t.start();
        Thread.sleep(500);
        System.out.println("Timed waiting thread" + t.getState());
    }

    public static void main(String[] args) {
        TimedWaitingThread t = new TimedWaitingThread();
        try {
            t.timedWaitingThread();
        } catch (InterruptedException ex) {
        }
    }
}
