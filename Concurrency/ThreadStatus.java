package Concurrency;

import java.util.Set;

public class ThreadStatus {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyThread());
            t.setName("MyThead:" + i);
            t.start();
        }
        /* This is a Java code snippet that prints out the details of all active threads in the same thread group as the current thread and counts them. Here's a breakdown:

1. `int threadCount = 0;` - This line initializes a variable `threadCount` to zero. This variable is used to count the number of threads in the same thread group as the current thread.

2. `Set<Thread> threadSet = Thread.getAllStackTraces().keySet();` - This line retrieves all active threads in the JVM. `Thread.getAllStackTraces()` returns a Map where each entry's key is a Thread and the value is an array of StackTraceElement. The `keySet()` method is then called on this Map to get a Set of all keys (i.e., all active threads).

3. The `for` loop iterates over each thread in `threadSet`.

4. `if(t.getThreadGroup() == Thread.currentThread().getThreadGroup())` - This `if` statement checks if the thread group of the current thread in the iteration (`t`) is the same as the thread group of the thread that is executing this code (`Thread.currentThread()`). If they are in the same group, the code inside the `if` block is executed.

5. `System.out.println("Thread: " + t + ":" + "state:" + t.getState());` - This line prints the details of the thread `t` and its state.

6. `++threadCount;` - This line increments the `threadCount` by one.

So, after this code is executed, it will print the details of all threads in the same thread group as the current thread and the value of `threadCount` will be the number of these threads. */

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
