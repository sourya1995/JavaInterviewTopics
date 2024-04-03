package Concurrency.ProducerConsumer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Sample {
    protected static final ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    protected static int data = 0;


    public static void writeToData() {
        RW_LOCK.writeLock().lock();
        try {   
            data++;
        } finally {
            RW_LOCK.writeLock().unlock();
        }
    }

    public static int readData() {
        RW_LOCK.readLock().lock();
        try {
            return data;
        } finally {
            RW_LOCK.readLock().unlock();
        }
    }
}
