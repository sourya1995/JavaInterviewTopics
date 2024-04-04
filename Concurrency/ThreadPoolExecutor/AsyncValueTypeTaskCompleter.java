package Concurrency.ThreadPoolExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AsyncValueTypeTaskCompleter implements Callable<Integer> {
    private int taskNumber;
     private static final Logger logger = Logger.getLogger(AsyncMaintenanceTaskCompleter.class.getName());


    public AsyncValueTypeTaskCompleter(int taskNumber) {
        this.taskNumber = taskNumber;
    }


    @Override
    public Integer call() throws Exception {
        int timeout = ThreadLocalRandom.current().nextInt(1, 20);
         try {
            logger.info(String.format("Task %d is sleeping for %d seconds", taskNumber, timeout));
            TimeUnit.SECONDS.sleep(timeout);
            logger.info(String.format("Task %d is done sleeping", taskNumber));
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
        }
        return timeout;
    }
    
    
}
