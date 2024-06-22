package JavaCodingProblems.Concurrency.Semaphore;

import java.util.logging.Logger;
import java.util.Random;

public class BarbershopCustomer implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(BarbershopCustomer.class.getName());
    private static final Random rnd = new Random();
    private final Barbershop barbershop;
    private final int customerId;

    public BarbershopCustomer(Barbershop barbershop, int customerId) {
        this.barbershop = barbershop;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        try {
            boolean acquired = barbershop.acquireSeat(customerId);
            if (acquired) {
                try {
                    Thread.sleep(rnd.nextInt(10 * 1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LOGGER.severe(() -> "Exception" + e);
                } finally {
                    barbershop.releaseSeat(customerId);
                }
            } else {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) { // Handle the InterruptedException explicitly here
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception acquiring seat: " + e);
        }

    }
}
