package Concurrency.MultipleProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue; //thread-safe
    private int threadNo;

    public Consumer(BlockingQueue<Integer> sharedQueue, int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }



    @Override
    public void run() {
       while (true) { 
           try {
               int num = sharedQueue.take();
               System.out.println("Consumed : " + num + "by thread: " + threadNo); //consumes continuously from queue
           } catch (Exception e) {
                e.printStackTrace();
           }
       }
    }
    
}
