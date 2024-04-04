package Concurrency.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class AsyncExample2 {
    private static final Logger log = Logger.getLogger(AsyncExample2.class.getName());
    public static void main(String[] args) throws ExecutionException {
    
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submittedFuture = (Future<Integer>) service.submit(new AsyncMaintenanceTaskCompleter(i));
            futures.add(submittedFuture);
        }
        service.shutdown();
        while(!futures.isEmpty()){
            for(int j = 0; j  < futures.size(); j++){
                Future<Integer> f = futures.get(j);
                if(f.isDone()){
                    try{
                        int timeout = f.get();
                        log.info(String.format("A task just completed after sleeping for %dseconds", timeout));
                        futures.remove(f);
                    }catch(InterruptedException e){
                        log.warning(e.getMessage());
                    }
                }
            }
        }
    }
}
