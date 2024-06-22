package JavaCodingProblems.Concurrency.Semaphore;

import java.util.logging.Logger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Barbershop {
    private static final Logger LOGGER = Logger.getLogger(Barbershop.class.getName());
    private final Semaphore seats;

    public Barbershop(int seatsCount) {
        this.seats = new Semaphore(seatsCount, true);
    }

    public boolean acquireSeat(int customerId) throws InterruptedException {
        LOGGER.info("Customer " + customerId + " is waiting");
        try {
            boolean acquired = seats.tryAcquire(5 * 1000, TimeUnit.MILLISECONDS);
            if (!acquired) {
                LOGGER.info("Customer " + customerId + "has left the barbershop");
                return false;
            }
            LOGGER.info("Customer " + customerId + " has acquired a seat");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception occurred" + e);
        }

        return false;

    }

    public void releaseSeat(int customerId) {
        LOGGER.info("Customer " + customerId + " has acquired a seat");
        seats.release();
    }

}
