package Concurrency;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        System.out.println("Time at task submission" + new Date());
        Future<String> result = es.submit(new ComplexCalculator());
        System.out.println("Result of complex calculation" + result.get());
        System.out.println("Time at the point of printing the result" + new Date());
    }
}
