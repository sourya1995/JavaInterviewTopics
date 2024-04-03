package Concurrency.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

import Concurrency.ProducerConsumer.ProducerConsumerExample.ProducedData;

public class Producer implements Runnable {
    private final BlockingQueue<ProducedData> queue;

    public Producer(BlockingQueue<ProducedData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       int producedCount = 0;
       try {
           while (true) { 
               producedCount++;
               queue.put(new ProducedData());
           }
       } catch (InterruptedException e) {
            producedCount--;
            Thread.currentThread().interrupt();
       }

       System.out.println("Produced" + producedCount + "objects");
    }

    
}
