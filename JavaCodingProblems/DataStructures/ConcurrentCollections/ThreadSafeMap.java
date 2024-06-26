package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.logging.Logger;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Iterator;



public class ThreadSafeMap {
    private static final Logger LOGGER = Logger.getLogger(ThreadSafeMap.class.getName());
    private static final ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static final ExecutorService producerService = Executors.newSingleThreadExecutor();
    private static final ExecutorService consumerService = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while(true){
                int item = (int) (Math.random() * 1000);
                map.put(item, item);
                LOGGER.info(() -> "Produced:" + item + "by" + Thread.currentThread().getName());
            }
        }

        
        
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
           while (true) { 
               Iterator<Integer> iterator = map.keySet().iterator();
               while(iterator.hasNext()){
                try {
                    Integer item = iterator.next();
                    LOGGER.info( () -> "Consumed:" + item + "by" + Thread.currentThread().getName());
                } catch (Exception e) {
                    LOGGER.severe(() -> "Exception: " + e);
                    System.exit(0);
                }
               }
           }
        }
        
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
        "[%1$tT] [%4$-7s] %5$s %n");
        producerService.execute(producer);
        consumerService.execute(consumer);
        producerService.shutdown();
        consumerService.shutdown();
    }
}
