package Concurrency.CountDownLatchConcept;

import java.util.concurrent.CountDownLatch;

public class DoSomethingInAThread implements Runnable {

    CountDownLatch latch;

    public DoSomethingInAThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("kuch karo bhai");
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
