package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        SimpleRangeRandom simpleRangeRandom = new SimpleRangeRandom(1, 10);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("test");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(simpleRangeRandom);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleRangeRandom rangeRandom = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("test");
            ois = new ObjectInputStream(fis);
            rangeRandom = (SimpleRangeRandom) ois.ReadObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
