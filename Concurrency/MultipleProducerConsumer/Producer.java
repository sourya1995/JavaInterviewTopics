package Concurrency.MultipleProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;
    private Random random = new Random();
    

    public Producer(BlockingQueue<Integer> sharedQueue, int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }


    @Override
    public void run() {
        while (true) { 
            try {
                int number = random.nextInt(100);
                System.out.println("Produced: " + number + ":by thread" + threadNo);
                sharedQueue.put(number);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
