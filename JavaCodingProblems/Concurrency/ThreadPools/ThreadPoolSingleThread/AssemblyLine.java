import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.logging.Logger;

public class AssemblyLine {
    private AssemblyLine() {
        throw new AssertionError("cannot instantiate - there is a single assembly line");
    }

    private static ExecutorService producerService; // one thread for Producer
    private static ExecutorService consumerService; // one thread for Consumer

    private static final TransferQueue<String> queue = new LinkedTransferQueue<>(); // Producer waits to check if
                                                                                    // consumer is available + FIFO
    /* private static final Queue<String> queue
 = new ConcurrentLinkedQueue<>(); */  //ffor non-blocking consumer                                                                                 
    private static final int MAX_PROD_TIME_MS = 5 * 1000; // 5 seconds
    private static final int MAX_CONSUME_TIME_MS = 7 * 1000; // 7 seconds
    private static final int TIMEOUT_MS = MAX_CONSUME_TIME_MS + 1000;
    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);
                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));
                    boolean transferred = queue.tryTransfer(bulb, TIMEOUT_MS, TimeUnit.MILLISECONDS); //queue.offer(bulb) for ConcurrentLinkedQueue
                    if (transferred) {
                        logger.info(() -> "check ho gaya:" + bulb);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception:" + e);
                    break;
                }
            }

        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll(MAX_PROD_TIME_MS, TimeUnit.MILLISECONDS); //queue.poll() for ConcurrentLinkedQueue
                    if (bulb != null) {
                        Thread.sleep(rnd.nextInt(MAX_CONSUME_TIME_MS));
                        logger.info(() -> "bulb packed:" + bulb);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception:" + e);
                    break;
                }
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
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);
        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumerService.execute(consumer);

    }

    public static void stopAssemblyLine() {

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.severe(() ->"Something abnormal happened during shutting down the assembling line!");
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
