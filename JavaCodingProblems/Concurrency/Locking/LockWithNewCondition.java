package JavaCodingProblems.Concurrency.Locking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class LockWithNewCondition {
	private static final Logger LOGGER = Logger.getLogger(LockWithNewCondition.class.getName());
	private static final ReentrantLock lock = new ReentrantLock();
	private static final Condition condition = lock.newCondition();
	
	public void executeByT1() throws InterruptedException {
		lock.lock();
		try {
			LOGGER.info(() -> "Thread" + Thread.currentThread().getName() + "waiting for T2 to signal the condition");
			condition.await();
			Thread.sleep(2000);
			LOGGER.info(() -> "Thread" + Thread.currentThread().getName() + "has finished execution");
			
		}finally {
			lock.unlock();
		}
	}
	
	public void executeByT2() throws InterruptedException {
		lock.lock();
		try {
			LOGGER.info(() -> "Thread" + Thread.currentThread().getName() + "signalled the condition");
			condition.signal();
			Thread.sleep(2000);
			LOGGER.info(() -> "Thread" + Thread.currentThread().getName() + "has finished execution");
			
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("java.util.logging.SimpleFormatter.format",
	                "[%1$tT] [%4$-7s] %5$s %n");
		 
		 LockWithNewCondition lockWithNewCondition = new LockWithNewCondition();
		 
		 Runnable taskT1 = () -> {
			 try {
				 lockWithNewCondition.executeByT1();
			 }catch (InterruptedException ex) {
				 Thread.currentThread().interrupt();
				 LOGGER.severe(() -> "Exception" + ex);
			 }
		 };
		 
		 Runnable taskT2 = () -> {
			 try {
				 lockWithNewCondition.executeByT2();
			 }catch (InterruptedException ex) {
				 Thread.currentThread().interrupt();
				 LOGGER.severe(() -> "Exception" + ex);
			 }
		 };
		 
		 Thread t1 = new Thread(taskT1, "t1");
		 t1.start();
		 
		 Thread.sleep(2000);
		 
		 Thread t2 = new Thread(taskT2, "t2");
		 t2.start();

	}
}
