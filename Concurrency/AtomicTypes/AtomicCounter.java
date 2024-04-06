package Concurrency.AtomicTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger[] counters;

    public AtomicCounter(int numCounters) {
        counters = new AtomicInteger[numCounters];
        for (int i = 0; i < numCounters; i++) {
            counters[i] = new AtomicInteger(); //initialize each item in the array
        }
    }

    public void count(int number){
        if(number >= 0 && number < counters.length){
            counters[number].incrementAndGet();
        }
       
    }

    public int getCount(int number){
        return (number >= 0 && number < counters.length) ? counters[number].get() : -1;
    }
    
}

/* 
 * here, locking is not necessary because the counter operations are thread-safe and atomic
 * - each counter can only be seen in a "before" or "After" state
 * - atomic types depend on hardware instruction set
 * - JVM uses them to implement uncontended locking - use CAS to acquire locks
 * - https://en.wikipedia.org/wiki/Compare-and-swap
 */
