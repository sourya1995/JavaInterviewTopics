package JavaCodingProblems.Concurrency.AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicCount implements Runnable {
    private static AtomicInteger count = new AtomicInteger(2);

    @Override
    public void run() {
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicCount atomicCount = new AtomicCount();
        System.out.println(atomicCount.getCount());
        
        AtomicIntegerArray atomicArray
        = new AtomicIntegerArray(new int[] {3, 4, 2, 5});
        
        for(int i =0; i < atomicArray.length(); i++) {
        	atomicArray.updateAndGet(i, x -> x * x);
        }
        
        System.out.println(atomicArray);
        

    }


}
