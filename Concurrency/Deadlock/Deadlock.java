package Concurrency.Deadlock;

public class Deadlock {
    Object mLock1 = new Object();
    Object mLock2 = new Object();

    public void methodA(){
        System.out.println("Method A wait for mLock1" + Thread.currentThread().getName());
        synchronized(mLock1){
            System.out.println("Method A mLock acquired" + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
                method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2() throws InterruptedException  {
        System.out.println("method 2 wait for mLock2" + Thread.currentThread().getName());
        synchronized(mLock2){
            System.out.println("method2 mLock2 acquired" + Thread.currentThread().getName());
            Thread.sleep(100);
            method3();
        }
    }

    public void method3() throws InterruptedException{
        System.out.println("method 3 mLock1 " + Thread.currentThread().getName());
        synchronized (mLock1) {
            System.out.println("method 3 mLock1 acquired" + Thread.currentThread().getName());
        }
    }
}
