package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteSerialClassIntoFIle {
    public static void main(String[] args) {
        String filename = "time.ser";
        SerialClass time = new SerialClass();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(time);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
