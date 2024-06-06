package JavaCodingProblems.DataStructures.ConcurrentCollections;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.logging.Logger;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.ExecutorService;
import java.util.UUID;




public class LinkedTransferQueueExample {
    private static final Logger LOGGER = Logger.getLogger(LinkedTransferQueueExample.class.getName());

    private static final TransferQueue<String> QUEUE = new LinkedTransferQueue<>();

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
        "[%1$tT] [%4$-7s] %5$s %n");

        ExecutorService executorProducer = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorProducer.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String item = UUID.randomUUID().toString();
                        LOGGER.info(() -> "Produced:" + item + "by" + Thread.currentThread().getName());
                        QUEUE.transfer(item);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ExecutorService consumerService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++){
            consumerService.execute(() -> {
                try {
                    String item = QUEUE.take();
                    LOGGER.info(() -> "Consumed:" + item + "by:" + Thread.currentThread().getName());
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorProducer.shutdown();
        consumerService.shutdown();

        executorProducer.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        LOGGER.info("Done");

    }

}
