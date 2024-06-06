package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.logging.Logger;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class ConcurrentLinkedDequeExample  {
    private static final Logger LOGGER = Logger.getLogger(ConcurrentLinkedDequeExample.class.getName());
    private static final Queue<Integer> queue = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.util.logging.SimpleFormatter.format",
        "[%1$tT] [%4$-7s] %5$s %n");

        LOGGER.info("enque");

        for (int i = 0; i < 10; i++) {
            int item = i + 1;
            LOGGER.info(() -> "Produced" + item + "by" + Thread.currentThread().getName());
            queue.offer(item);
        }

        LOGGER.info("deque");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Integer item = queue.poll();
                if(item != null){
                    LOGGER.info(() -> "Consumed: " + item + "by" + Thread.currentThread().getName());
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        LOGGER.info("All threads have ended successfully");
    }
}
