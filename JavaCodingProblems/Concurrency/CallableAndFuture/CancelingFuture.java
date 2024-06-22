package JavaCodingProblems.Concurrency.CallableAndFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CancelingFuture {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(10000);
            return "Hello World!";
        });

        while(!future.isDone()){
            System.out.println("task in progress");
            Thread.sleep(1000);
            if(System.currentTimeMillis() - startTime > 10000){
                future.cancel(true);
            }
        }

        try {
            System.out.println(future.get());
        } catch (Exception e) {

        }

        System.out.println("Done!" + future.isDone() + future.isCancelled());



    }
}
