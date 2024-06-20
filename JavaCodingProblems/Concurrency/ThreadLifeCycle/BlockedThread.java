package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class BlockedThread {
    public void blockedThread() throws InterruptedException {
        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());
        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);
        System.out.println("BlockedThread t1: "
                + t1.getState() + "(" + t1.getName() + ")");
        System.out.println("BlockedThread t2: "
                + t2.getState() + "(" + t2.getName() + ")");
        System.exit(0);

    }

    private static class SyncCode implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName() + " is running in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread" + Thread.currentThread().getName() + " is running in syncMethod()");

            while (true) {
                // t1 will stay here forever
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockedThread bt = new BlockedThread();
        bt.blockedThread();

    }
}
