package Concurrency.ThreadLocalConcept;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample instance = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(instance, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        }

   

    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName()
                + ", Date: " + formatter.get().format(new java.util.Date()));
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread name: " + Thread.currentThread().getName()
                + ", Date: " + formatter.get().format(new java.util.Date()));
    }
    
}
