package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class WaitingThread {
    public void WaitingThread() {
        new Thread(() -> {
            Thread t1 = Thread.currentThread();
            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                System.out.println("WaitingThread t1:" + t1.getState());
            });
            t2.start(); 
            try {
                t2.join(); // current thread will wait for t2 to finish executing
            } catch (InterruptedException ex) {
            }
        }).start();
    }

    public static void main(String[] args) {
        WaitingThread wt = new WaitingThread();
        wt.WaitingThread();
    }
}
