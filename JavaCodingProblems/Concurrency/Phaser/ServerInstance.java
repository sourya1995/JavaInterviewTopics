package JavaCodingProblems.Concurrency.Phaser;

import java.util.logging.Logger;

import JavaCodingProblems.Concurrency.CyclicBarrier.ServerService;

import java.util.concurrent.Phaser;

public class ServerInstance implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ServerInstance.class.getName());
    private final Phaser phaser = new Phaser(1) {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) { //logs number of registered parties
            LOGGER.warning(() -> "Phase:" + phase + " registeredParties:" + registeredParties);
            return registeredParties == 0;
        }
    }; //controller thread

    @Override
    public void run() {
        long starting = System.currentTimeMillis();
        LOGGER.info("Starting");
        LOGGER.info("starting the first three services");
        startFirstThreeServices();
        LOGGER.info("Starting the next two services");
        startNextTwoServices();
        LOGGER.info("All services are running ... final check in ...\n");
        finalCheckIn();

        LOGGER.info(() -> "Server was successfully started in "
                + (System.currentTimeMillis() - starting) / 1000 + " seconds");

        LOGGER.warning(() -> "Phaser is terminated: " + phaser.isTerminated()
                + " | " + phaser.getRegisteredParties());

    }

    private void startFirstThreeServices() {
        Thread service1 = new Thread(new ServerService(phaser, "HTTP Listeners"));
        Thread service2 = new Thread(new ServerService(phaser, "JMX"));
        Thread service3 = new Thread(new ServerService(phaser, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        phaser.arriveAndAwaitAdvance(); //controller is waiting

    }

    private void startNextTwoServices() {
        Thread service4 = new Thread(new ServerService(phaser, "Virtual Hosts"));
        Thread service5 = new Thread(new ServerService(phaser, "Ports"));

        service4.start();
        service5.start();

        phaser.arriveAndAwaitAdvance(); //controller is waiting
    }

    private void finalCheckIn() {
        try {
            LOGGER.info("Finalizing process...");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception: " + ex);
        } finally {
            phaser.arriveAndDeregister(); //controller is waiting
        }
    }

}
