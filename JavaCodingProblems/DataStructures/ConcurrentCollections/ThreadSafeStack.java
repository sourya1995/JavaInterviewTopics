package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Logger;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




public class ThreadSafeStack {
    private static final Logger LOGGER = Logger.getLogger(ThreadSafeStack.class.getName());
    private static Deque<Integer> stack = new ConcurrentLinkedDeque<>();
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("java.util.logging.SimpleFormatter.format",
        "[%1$tT] [%4$-7s] %5$s %n");

        LOGGER.info("Push..."); //using only one thread
        for (int i = 0; i <10; i++) {
            int item = i + 1;
            LOGGER.info(() -> "Produced:" + item + "by" + Thread.currentThread().getName());
            stack.push(item);
        }

        LOGGER.info("Pop..."); //using multiple threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                Integer item = stack.pop();
                LOGGER.info(() -> "Consumed:" + item + "by" + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        LOGGER.info("All threads have been shut down");
    }
}
