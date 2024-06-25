package JavaCodingProblems.Concurrency.PerThreadContextThreadLocal;

import java.util.logging.Logger;
import java.util.Random;

public class CustomerOrder implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(CustomerOrder.class.getName());
    private static final Random random = new Random();
    private static final ThreadLocal<Order> customerOrder = new ThreadLocal<>();
    private final int customerId;

    public CustomerOrder(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public void run() {
        LOGGER.info(() -> "Given customer id: " + customerId
                + " | " + customerOrder.get()
                + " | " + Thread.currentThread().getName());
        customerOrder.set(new Order(customerId));
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception" + e);
        }

        LOGGER.info(() -> "Given customer id: " + customerId
                + " | " + customerOrder.get()
                + " | " + Thread.currentThread().getName());

        customerOrder.remove();

    }

    public static void main(String[] args) {
        CustomerOrder co1 = new CustomerOrder(1);
        CustomerOrder co2 = new CustomerOrder(2);
        CustomerOrder co3 = new CustomerOrder(3);
        new Thread(co1).start();
        new Thread(co2).start();
        new Thread(co3).start();
    }

}
