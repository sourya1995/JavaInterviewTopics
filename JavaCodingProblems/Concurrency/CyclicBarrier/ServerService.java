package JavaCodingProblems.Concurrency.CyclicBarrier;

import java.util.Random;
import java.util.logging.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.BrokenBarrierException;

public class ServerService implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ServerService.class.getName());
    private final String serviceName;
    private final Random rnd = new Random();

    private final CyclicBarrier barrier;

    public ServerService(Phaser phaser, String serviceName) {
        this.barrier = phaser;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        int startingIN = rnd.nextInt(10) * 1000;
        try {
            LOGGER.info(() -> "Starting service '" + serviceName + "' ...");
            Thread.sleep(startingIN);

            LOGGER.info(() -> "Service '" + serviceName
                    + "' has successfully started in " + startingIN / 1000 + " seconds");
            barrier.await();
            LOGGER.info(() -> "Service '" + serviceName + "' running ...");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            ex.printStackTrace();
        } catch (BrokenBarrierException ex) {
            LOGGER.severe(() -> "Barrier is broken" + ex.getMessage());
        }
    }

}
