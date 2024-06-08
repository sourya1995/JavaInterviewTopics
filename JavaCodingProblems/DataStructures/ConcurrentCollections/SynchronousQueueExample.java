package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

public class SynchronousQueueExample {
    private static final Logger LOGGER = Logger.getLogger(SynchronousQueueExample.class.getName());
    private static final BlockingQueue<String> QUEUE = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                String item = QUEUE.take();
                LOGGER.info(() -> "Item: " + item + "Consumed By:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        });

        LOGGER.info("Sleep for 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }

        LOGGER.info("Enqueue...");
        QUEUE.offer("Roger Federer");
        // others won't get in
        QUEUE.offer("Rafael Nadal");
        QUEUE.offer("Novak Djokovic");
        LOGGER.info("Done...");

        LOGGER.info(() -> "Queue size" + QUEUE.size());
        executorService.shutdown();
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MILLISECONDS);
        LOGGER.info("Done. All threads ended successfully.");

    }

}
