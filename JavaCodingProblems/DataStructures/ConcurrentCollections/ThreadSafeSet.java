package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

import java.util.concurrent.ExecutorService;

import java.util.Set;
import java.util.concurrent.Executors;


public class ThreadSafeSet {
    private static final Logger LOGGER = Logger.getLogger(ThreadSafeSet.class.getName());
    private static Set<Integer> set = new CopyOnWriteArraySet<>();
    private static final Consumer consumer = new Consumer();
    private static final Producer producer = new Producer();
    private static ExecutorService producerService = Executors.newSingleThreadExecutor();
    private static ExecutorService consumerService = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) { 
               int item = (int) (Math.random() * 1000);
               set.add(item);
               LOGGER.info("Produced: " + item + "by" + Thread.currentThread().getName());
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) { 
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    try {
                        LOGGER.info(() -> "Consumed: " + iterator.next() + "by" + Thread.currentThread().getName());
                    } catch (ConcurrentModificationException e) {
                    }
            }
        }

    }


    public static void main(String[] args) {
        producerService.execute(producer);
        consumerService.execute(consumer);
    }

}
