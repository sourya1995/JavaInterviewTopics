package JavaCodingProblems.Concurrency.PerThreadInstanceThreadLocal;

import java.util.Random;
import java.util.logging.Logger;

public class ThreadSafeStringBuilder implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ThreadSafeStringBuilder.class.getName());
    private static final Random random = new Random();

    private static final ThreadLocal<StringBuilder> threadLocal = ThreadLocal.<StringBuilder>withInitial(() -> {
        return new StringBuilder("Thread-safe ");
    });

    @Override
    public void run() {
        LOGGER.info(() -> "->" + Thread.currentThread().getName() + " [" + threadLocal.get() + "] ");
        try {
            Thread.sleep(random.nextInt(2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(() -> "Exception" + e);
        }

        threadLocal.get().append(Thread.currentThread().getName());
        LOGGER.info(() -> "->" + Thread.currentThread().getName() +  " [" + threadLocal.get() + "] ");
        threadLocal.set(null);
        LOGGER.info(() -> "->" + Thread.currentThread().getName() +  " [" + threadLocal.get() + "] ");

    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
        ThreadSafeStringBuilder threadSafeStringBuilder = new ThreadSafeStringBuilder();
        for (int i = 0; i < 3; i++) {
            new Thread(threadSafeStringBuilder, "thread-" + i).start();            
        }  
      
    }

}
