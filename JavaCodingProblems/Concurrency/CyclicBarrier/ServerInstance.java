package JavaCodingProblems.Concurrency.CyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import java.lang.Thread;
import java.util.concurrent.CyclicBarrier;

public class ServerInstance implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ServerInstance.class.getName());
    private final Runnable barrierAction = () -> LOGGER.info("Services ready to start");
    CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);

    @Override
    public void run() {
        LOGGER.info("The server is getting ready to start ");
        LOGGER.info("Starting services ...\n");
        long starting = System.currentTimeMillis();

        Thread service1 = new Thread(new ServerService(barrier, "HTTP Listeners"));
        Thread service2 = new Thread(new ServerService(barrier, "JMX"));
        Thread service3 = new Thread(new ServerService(barrier, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        try {
            service1.join();
            service2.join();
            service3.join();
            LOGGER.info(() -> "Server started in " + (System.currentTimeMillis() - starting) + " milliseconds");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception:" + e);
        }

    }
}
