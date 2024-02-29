package Collections.Queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        queue.put("one");
        System.out.println("1 done");
        queue.put("two");
        System.out.println("2 done"); // after this, thread will block until another thread clears space
        queue.put("three");
        System.out.println("3 done");

        /*
         * System.out.println(queue.take());
         * System.out.println(queue.take());
         * System.out.println(queue.take());
         */
    }
}
