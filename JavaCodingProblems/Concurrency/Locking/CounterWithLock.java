package JavaCodingProblems.Concurrency.Locking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class CounterWithLock {
	private static final Logger LOGGER = Logger.getLogger(CounterWithLock.class.getName());
	private static final Lock lock = new ReentrantLock();
	private static int count;
	
	public void counter() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
		CounterWithLock counterWithLock = new CounterWithLock();
		Runnable task = () -> {
			counterWithLock.counter();
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		for(int i = 0; i < 1_000_000; i++) {
			executorService.execute(task);
		}
		
		executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);

        LOGGER.info(() -> "Final result: " + count);
	}
	
	
}
