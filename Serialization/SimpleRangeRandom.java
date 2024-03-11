package Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class SimpleRangeRandom implements Runnable, Serializable {
    private int min;
    private int max;

    private transient Thread thread;

    public SimpleRangeRandom(int min, int max) {
        this.min = min;
        this.max = max;
        thread = new Thread(this);
        thread.start();
    }

   
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void ReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            Random rand = new Random();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
