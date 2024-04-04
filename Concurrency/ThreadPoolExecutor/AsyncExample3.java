package Concurrency.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class AsyncExample3 {

    private static final Logger log = Logger.getLogger(AsyncExample3.class.getName());

    // Main method
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            service.execute(() ->  {
                int timeout = getTimeout();
                try {
                    Thread.sleep(timeout * 1000);
                } catch (InterruptedException e) {
                    log.severe(e.getMessage());
                }
                log.info(String.format("Runnable %d has finished sleeping", index));
            });
            Future<Integer> submittedFuture = service.submit(() -> {
                int timeout = getTimeout();
                try {
                    Thread.sleep(timeout * 1000);
                } catch (InterruptedException e) {
                    log.severe(e.getMessage());
                }
                log.info(String.format("Runnable %d has finished sleeping", index));
                return timeout;
            });
            futures.add(submittedFuture);
        
        }
        service.shutdown();
        while(!futures.isEmpty()){
            for (int j = 0; j < futures.size(); j++){
                Future<Integer> f = futures.get(j);
                if(f.isDone()){
                    try {
                        int timeout = f.get();
                        log.info(String.format("A task just completed after sleeping for %dseconds", timeout));
                        futures.remove(j);
                    } catch (Exception e) {
                        log.severe(e.getMessage());
                    }
                }
            
            }
        }

    }

    public static int getTimeout() {
        return ThreadLocalRandom.current().nextInt(1, 20);
    }
}
