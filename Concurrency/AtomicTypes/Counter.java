package Concurrency.AtomicTypes;

public class Counter {
    private final int[] counters;

    public Counter(int numberOfcounters) {
        counters = new int[numberOfcounters];
    }

    public synchronized void count(int number){
        if(number >= 0 && number < counters.length){
            counters[number]++; //increment the integer at given index
        }
    }

    public synchronized int getCount(int number){
        return (number >= 0 && number < counters.length) ? counters[number] : -1; //return the integer at given index or -1 if invalid index)
    }

    
}
/* The issue with this code is - if there are a large number of threads, there will be a bottleneck - lock contention
 *  - each synchronized method call will start the current thread acquiring lock for the Counter instance
 * - it will hold the lock until the number value is checked , then the counter is updated accordingly
 * - finally the lock is released for others to access
 * - if one thread attempts to acquire the lock while another thread is holding the lock, the attempting thread will BLOCK
 * - if multiple threads attempt to acquire the lock, one of them will get it, others will continue to block
 * - the OS will try to switch to another thread - this has a HUGE performance impact on processor
 * - if multiple threads are waiting, fairness is not guaranteed - this could lead to starvation
 */