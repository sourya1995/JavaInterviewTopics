package JavaCodingProblems.IO;

public class CircularByteBuffer {
    
    private int capacity;
    private byte[] buffer;
    private int readPointer;
    private int writePointer;
    private int available;

    public CircularByteBuffer(int capacity) {
        buffer = new byte[capacity];
        this.capacity = capacity;
       
    }

    public synchronized int available() {
        return available;
    }

    public synchronized int capacity() {
        return capacity;
    }

    public synchronized int slots() {
        return capacity - available;
    }

    public synchronized void clear() {
        readPointer = writePointer = available = 0;
    }

    public synchronized boolean put(int value){
        if(available == capacity){
            return false;
        }

        buffer[writePointer++] = (byte) value;
        writePointer = (writePointer + 1) % capacity;
        available++;

        return true;
    }

    public synchronized int get(){
        if (available  == 0){
            return -1;
        }

        int value = buffer[readPointer++];
        readPointer = (readPointer + 1) % capacity;
        available--;

        return value;

    }

    //TODO: implement other methods



}
