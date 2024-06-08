package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapKeySetView {
    private MapKeySetView() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final Logger LOGGER = Logger.getLogger(MapKeySetView.class.getName());
    private static final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    private static final AtomicInteger count = new AtomicInteger();
    private static final KeySetView<Integer, Integer> keySetView = map.keySet(-1);
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final ExecutorService producerService = Executors.newFixedThreadPool(2);
    private static final ExecutorService consumerService = Executors.newFixedThreadPool(2);
    private static final Random rnd = new Random();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(rnd.nextInt(3000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOGGER.severe(() -> "Exception:" + e);
                }
                int item = (int) (Math.random() * 1000);
                LOGGER.info(() -> "Produced" + item + "by" + Thread.currentThread().getName());
                map.put(count.incrementAndGet(), item);
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(rnd.nextInt(3000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOGGER.severe(() -> "Exception:" + e);
                }
                LOGGER.info(() -> "Key set view" + keySetView + "by" + Thread.currentThread().getName());
                int size = keySetView.size();
                if (size > 1) {
                    int position = 1 + rnd.nextInt(size - 1);
                    if (position <= size / 2) {
                        LOGGER.info(() -> "Adding item -1 to map on position" + (size + 1) + "by"
                                + Thread.currentThread().getName());
                        keySetView.add(size + 1);
                        LOGGER.info(() -> "Map after add -1: " + keySetView.getMap() + "by"
                                + Thread.currentThread().getName());
                    } else {
                        LOGGER.info(() -> "Removing item -1 from map on position" + position + "by"
                                + Thread.currentThread().getName());
                        keySetView.remove(position);
                        LOGGER.info(() -> "Map after removing item" + keySetView.getMap() + "by"
                                + Thread.currentThread().getName());
                    }
                }

            }
        }

    }

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        for (int i = 0; i < 2; i++) {
            producerService.submit(producer);
            consumerService.submit(consumer);
        }

    }

}
