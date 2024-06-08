package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.logging.Logger;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class NormalThreadSafeStack {
    private static final Logger LOGGER = Logger.getLogger(NormalThreadSafeStack.class.getName());
    private static Stack<Integer> stack = new Stack<>();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();
    private static ExecutorService producerService = Executors.newSingleThreadExecutor();
    private static ExecutorService consumerService = Executors.newSingleThreadExecutor();

    private static class Producer implements Runnable {

        @Override
        public void run() {
           while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int item = (int) (Math.random() * 1000);
                stack.push(item);
                LOGGER.info(() -> "Produced" + item + "by" + Thread.currentThread().getName())
           }
        }
        
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                int item = stack.pop();
                LOGGER.info(() -> "Consumed" + item + "by" + Thread.currentThread().getName());
            }
        }
    }



    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        producerService.execute(producer);
        consumerService.execute(consumer);
    }




}
