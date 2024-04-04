package Concurrency.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InvokeAllDemo {

    public InvokeAllDemo() {
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<MyCallable> futureList = new ArrayList<MyCallable>();
        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable((long) i);
            futureList.add(myCallable);

        }
        System.out.println("Start");
        try {
            List<Future<Long>> futures = service.invokeAll(futureList); //executes given tasks, returns a list of Futures holding their status and results when 
            //everything is completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
        service.shutdown();

    }

    public static void main(String[] args) {
        InvokeAllDemo invokeAllDemo = new InvokeAllDemo();
    }

    class MyCallable implements Callable<Long> {

        Long id = 0L;

        public MyCallable(Long val) {
            this.id = val;
        }

        @Override
        public Long call() throws Exception {
            return id;
        }

    }

    void shutdownAndAwaitTermination(ExecutorService pool) throws InterruptedException{
        pool.shutdown(); //disable new tasks from being submitted
        try{
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)) { //wait for all tasks currently running to finish
                pool.shutdownNow(); //cancel currently running tasks
                if(!pool.awaitTermination(60, TimeUnit.SECONDS))
                System.out.println("pool did not terminate");
            }
        }catch (InterruptedException ie) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
