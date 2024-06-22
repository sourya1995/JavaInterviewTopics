package JavaCodingProblems.Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import java.lang.Thread;


public class ServerInstance implements Runnable{

    private static final Logger LOGGER = Logger.getLogger(ServerInstance.class.getName());
    private final CountDownLatch latch = new CountDownLatch(3);
    

    @Override
    public void run() {
        LOGGER.info("The server is getting ready to start ");
        LOGGER.info("Starting services ...\n");
        long starting = System.currentTimeMillis();

        Thread service1 = new Thread(new ServerService(latch, "HTTP Listeners"));
        Thread service2 = new Thread(new ServerService(latch, "JMX"));
        Thread service3 = new Thread(new ServerService(latch, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        try {
            latch.await();
            LOGGER.info(() -> "Server started in " + (System.currentTimeMillis() - starting) + " milliseconds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }



       
    }
    
}
