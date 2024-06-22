package JavaCodingProblems.Concurrency.CountDownLatch;

import java.util.Random;
import java.util.logging.Logger;
import java.util.concurrent.CountDownLatch;

public class ServerService implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ServerService.class.getName());
    private final String serviceName;
    private final Random rnd = new Random();

    private final CountDownLatch latch;

    public ServerService(CountDownLatch latch, String serviceName) {
        this.latch = latch;
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
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        ex.printStackTrace();
    } finally {
        latch.countDown();
        LOGGER.info(() -> "latch pressed. Current count is:" +  latch.getCount());
        LOGGER.info(() -> "Service '" + serviceName + "' running ...");
    }
    }
    
}
