package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.logging.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ThreadSafeList {
    private static final Logger LOGGER = Logger.getLogger(ThreadSafeList.class.getName());
    private static final List<Integer> list = new CopyOnWriteArrayList<>();
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static ExecutorService consumerService = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int item = (int) (Math.random() * 1000);
                list.add(item);
                LOGGER.info("Produced: " + item + "by" + Thread.currentThread().getName());
            }
        }

    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                Iterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    try {
                        Integer item = iterator.next();
                        LOGGER.info(() -> "Consumed:" + item + "by" + Thread.currentThread().getName());
                    } catch (ConcurrentModificationException e) {
                        LOGGER.severe(() -> "Exception: " + e);
                        System.exit(0);
                    }
                }
            }

        }

        public void consume(Integer value) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("[%s] consumed: %s\n", threadName, value);
        }


    }

    
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        executorService.execute(producer);
        consumerService.execute(consumer);
    }
}
