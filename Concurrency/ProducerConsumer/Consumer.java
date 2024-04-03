package Concurrency.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import Concurrency.ProducerConsumer.ProducerConsumerExample.ProducedData;

public class Consumer implements Runnable {
    private final BlockingQueue<ProducedData> queue;

    public Consumer(BlockingQueue<ProducedData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int consumedCount = 0;
        try {
            while (true) { 
                ProducedData data = queue.poll(10, TimeUnit.MILLISECONDS);
                consumedCount++;
            }
        } catch (InterruptedException e) {
            consumedCount--;
            Thread.currentThread().interrupt();
        }
        System.out.println("Consumed" + consumedCount + "objects");
    }

    

    
}
