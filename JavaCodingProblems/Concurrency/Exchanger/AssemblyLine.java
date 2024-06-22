package JavaCodingProblems.Concurrency.Exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public class AssemblyLine {
    private AssemblyLine() {
        throw new AssertionError("cannot instantiate - there is a single assembly line");
    }

    private static ExecutorService producerService; // one thread for Producer
    private static ExecutorService consumerService; // one thread for Consumer
    private static final int PRODUCERS = 3;
    private static final int CONSUMERS = 2;

    private static final TransferQueue<String> queue = new LinkedTransferQueue<>(); // Producer waits to check if
                                                                                    // consumer is available + FIFO
    /*
     * private static final Queue<String> queue
     * = new ConcurrentLinkedQueue<>();
     */ // ffor non-blocking consumer
    private static final Exchanger<List<String>> exchanger = new Exchanger<>();
    private static final int BASKET_CAPACITY = 5;
    private static final int MAX_PROD_TIME_MS = 5 * 1000; // 5 seconds
    private static final int MAX_CONSUME_TIME_MS = 7 * 1000; // 7 seconds
    private static final int TIMEOUT_MS = (MAX_CONSUME_TIME_MS + MAX_PROD_TIME_MS) * (PRODUCERS + CONSUMERS);
    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static class Producer implements Runnable {

        private List<String> basket = new ArrayList<>(BASKET_CAPACITY);

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    for (int i = 0; i < BASKET_CAPACITY; i++) {
                        String bulb = "bulb-" + rnd.nextInt(1000);
                        Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));
                        basket.add(bulb);
                        logger.info(
                                () -> "checked and added:" + bulb + "by producer:" + Thread.currentThread().getName());
                    }

                    logger.info("time to exchange");
                    basket = exchanger.exchange(basket);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception:" + e);
                    break;
                }
            }

        }
    }

    private static class Consumer implements Runnable {

        private List<String> basket = new ArrayList<>(BASKET_CAPACITY);

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    logger.info("waiting for basket");
                    basket = exchanger.exchange(basket);
                    logger.info("time to consume");

                    for (String bulb : basket) {
                        if (bulb != null) {
                            Thread.sleep(rnd.nextInt(MAX_CONSUME_TIME_MS));
                            logger.info(() -> "consumed:" + bulb + "by consumer:" + Thread.currentThread().getName());
                        }
                    }

                    basket.clear();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception:" + e);
                    break;
                }
            }
        }

        public static void startAssemblyLine() {
            if (runningProducer || runningConsumer) {
                logger.info("Assembly line already running");
                return;
            }
            logger.info("\n\nStarting assembly line ...");
            logger.info(() -> "Remaining bulbs from previous run: \n"
                    + queue + "\n\n");
            runningProducer = true;
            producerService = Executors.newFixedThreadPool(PRODUCERS);
            for (int i = 0; i < PRODUCERS; i++) {
                producerService.execute(producer);
            }
            runningConsumer = true;
            consumerService = Executors.newFixedThreadPool(CONSUMERS);
            for (int i = 0; i < CONSUMERS; i++) {
                producerService.execute(consumer);
            }

        }

        public static void stopAssemblyLine() {

            boolean isProducerDown = shutdownProducer();
            boolean isConsumerDown = shutdownConsumer();

            if (!isProducerDown || !isConsumerDown) {
                logger.severe(() -> "Something abnormal happened during shutting down the assembling line!");
                System.exit(0);

            }
            logger.info("\n\nStopping assembly line ...");
        }

        private static boolean shutdownProducer() {
            runningProducer = false;
            return shutdownExecutor(producerService);

        }

        private static boolean shutdownConsumer() {
            runningConsumer = false;
            return shutdownExecutor(consumerService);
        }

        private static boolean shutdownExecutor(ExecutorService executor) {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                    executor.shutdownNow();

                    return executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS);
                }

                return true;
            } catch (InterruptedException ex) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception: " + ex);
            }
            return false;
        }

    }
}
