package JavaCodingProblems.Concurrency.Cancellation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        RandomList r1 = new RandomList();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(r1);
        }

        Thread.sleep(100);
        r1.cancel();
        System.out.println(r1.getRandoms());
    }
}
