package Concurrency;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AddIntArraysUsingThreadPool {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] result = new int[arr1.length];

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < result.length; i++) {
            final int worker = i;
            pool.submit(() -> result[worker] = arr1[worker] + arr2[worker]);
        }

        try {
            pool.shutdown();
            pool.awaitTermination(12, TimeUnit.SECONDS);
            
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }

        System.out.println(Arrays.toString(result));

    }
}
