package Concurrency;

import java.util.Set;

public class ThreadStatus {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyThread());
            t.setName("MyThead:" + i);
            t.start();
        }

        int threadCount = 0;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for(Thread t : threadSet) { //current thread
            if(t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
                System.out.println("Thread: " + t + ":" + "state:" + t.getState());
                ++threadCount;
            }
        }

        System.out.println("Thread count started by main thread:" + threadCount);
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
