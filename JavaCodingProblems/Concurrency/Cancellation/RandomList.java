package JavaCodingProblems.Concurrency.Cancellation;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class RandomList implements Runnable{
    private volatile boolean cancelled; //this variable is not cached by threads - so ONLY latest values are read by every thread
    private final List<Integer> randoms = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    

    @Override
    public void run() {
       while(!cancelled) {
            randoms.add(random.nextInt());
       }
    }

    public void cancel() {
        cancelled = true;
    }

    public List<Integer> getRandoms() {
        return randoms;
    }

    
    
}
