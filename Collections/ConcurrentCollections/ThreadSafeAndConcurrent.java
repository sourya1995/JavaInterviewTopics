package Collections.ConcurrentCollections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeAndConcurrent {
    public static final List<Integer> LIST = new CopyOnWriteArrayList<>();

    public static final class ModifierRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    LIST.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static final class IteratorRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (Integer i : LIST) {
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ModifierRunnable());
        Thread t2 = new Thread(new IteratorRunnable());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(LIST.size());
    }
}
