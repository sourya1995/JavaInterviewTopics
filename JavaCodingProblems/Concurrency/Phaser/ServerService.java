package JavaCodingProblems.Concurrency.Phaser;

import java.util.logging.Logger;
import java.util.Random;
import java.util.concurrent.Phaser;

public class ServerService implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ServerService.class.getName());
    private final String serviceName;
    private final Random rnd = new Random();
    private final Phaser phaser;

    public ServerService(Phaser phaser, String serviceName) {
        this.phaser = phaser;
        this.serviceName = serviceName;
        this.phaser.register();

    }

    @Override
    public void run() {
        int startingIn = rnd.nextInt(10) * 1000;
        try {
            LOGGER.info(serviceName + " starting in " + startingIn + "s");
            Thread.sleep(startingIn);
            LOGGER.info(() -> "Service '" + serviceName
                    + "' was started in " + startingIn / 1000
                    + " seconds (waiting for remaining services)");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception" + e);
        } finally {
            phaser.arriveAndDeregister();
        }

    }

}
