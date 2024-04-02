package Concurrency.Synchronized;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedExample {

    // private static int t = 0;
    private static Object mutex = new Object();
    private static AtomicInteger t = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(400);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                synchronized (mutex) { //if I remove this
                    // t++; //not atomic

                    int currentT = t.incrementAndGet();
                    System.out.println(MessageFormat.format("t: {0}", currentT));
                }
            });

        }
        executorService.shutdown();
    }
}
