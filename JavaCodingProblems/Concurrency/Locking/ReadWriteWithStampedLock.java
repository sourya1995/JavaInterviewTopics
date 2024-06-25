package JavaCodingProblems.Concurrency.Locking;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Logger;

public class ReadWriteWithStampedLock {
	private static final Logger logger = Logger.getLogger(ReadWriteWithStampedLock.class.getName());
	private static final Random rnd = new Random();
	private static final StampedLock lock = new StampedLock();

	private static final OptimisticReader optimisticReader = new OptimisticReader();
	private static final Writer writer = new Writer();
	private static int amount;
	
	private static class OptimisticReader implements Runnable {

		@Override
		public void run() {
			long stamp = lock.tryOptimisticRead();
			if (!lock.validate(stamp)) {
				stamp = lock.readLock();
				try {
					logger.info(() -> "Read amount:" + amount + "by" + Thread.currentThread().getName());
				}finally {
					lock.unlockRead(stamp);
				}
				logger.warning(() -> Thread.currentThread().getName() + "reports that the lock is taken by a writer");
			} else {
				logger.info(() -> "Read amount:" + amount + "by" + Thread.currentThread().getName());
			}
			
			

		}

	}
	
	private static class Writer implements Runnable {

		@Override
		public void run() {
			long stamp = lock.writeLock();
			try {
				Thread.sleep(rnd.nextInt(2000));
				logger.info(() -> "Increase amount by 10 by:" + Thread.currentThread().getName());
				amount += 10;
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				logger.severe(() -> "Exception" + ex);
			} finally {
				lock.unlockWrite(stamp);
			}

		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");
		
		ExecutorService readerService = Executors.newFixedThreadPool(2);
		ExecutorService writerService = Executors.newFixedThreadPool(4);
		
		for(int i = 0; i < 10; i++) {
			readerService.execute(optimisticReader);
			writerService.execute(writer);
		}
		
		readerService.shutdown();
		writerService.shutdown();
		readerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        writerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
	}

	
	
	
	

}
