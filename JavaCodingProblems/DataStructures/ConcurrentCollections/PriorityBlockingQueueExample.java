package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PriorityBlockingQueueExample {
    private static final Logger LOGGER = Logger.getLogger(PriorityBlockingQueueExample.class.getName());
    private static final BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        LOGGER.info("Enqueue ...");
        for (int i = 0; i < 10; i++) {
            int item = (int) (Math.random() * 1000);
            LOGGER.info(() -> "PRODUCED: " + item + "by" + Thread.currentThread().getName());
            queue.offer(item);
        }

        LOGGER.info("Dequeue...");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                }
                Integer item = queue.poll();
                if (item != null) {
                    LOGGER.info(() -> "Consumed: " + item + "by" + Thread.currentThread().getName());
                }
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
        LOGGER.info("Done.");

    }

}