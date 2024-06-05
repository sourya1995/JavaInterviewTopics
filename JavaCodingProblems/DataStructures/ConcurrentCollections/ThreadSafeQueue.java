package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ThreadSafeQueue {
    private static final Logger LOGGER = Logger.getLogger(ThreadSafeQueue.class.getName());
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10000);
    private static final AtomicInteger itemNr = new AtomicInteger();
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static ExecutorService producerService = Executors.newFixedThreadPool(3);
    private static ExecutorService consumerService = Executors.newFixedThreadPool(3);

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int item = itemNr.incrementAndGet();
                queue.add(item);
                LOGGER.info(() -> "produced" + item + "by" + Thread.currentThread().getName());
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                Integer item = queue.poll();
                if (item != null) {
                    LOGGER.info(() -> "consumed" + item + "from" + Thread.currentThread().getName());
                } else {
                    LOGGER.info("Queue is empty");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        for (int i = 0; i < 3; i++) {
            producerService.execute(producer);
            consumerService.execute(consumer);
        }
    }

}
