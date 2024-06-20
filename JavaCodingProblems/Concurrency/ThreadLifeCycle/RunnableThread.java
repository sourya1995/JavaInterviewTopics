package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class RunnableThread {
    public void runnableThread() {
        Thread t = new Thread(() -> {});
        t.start();

        System.out.println("RunnableThread: "+ t.getState());
    }

    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        runnableThread.runnableThread();
    }
}
