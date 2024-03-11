package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSerialClassFromFile {
    public static void main(String[] args) {
        String filename = "time.ser";
        SerialClass time = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            time = (SerialClass) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        System.out.println("Restored time:" + time.getCurrentTime());
    }
}
