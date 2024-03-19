package IO.IOandNIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileStreamTWR {
    public static void main(String[] args) {
        String filepath = "test.txt";
        try (FileOutputStream fos = new FileOutputStream(filepath)){
            byte[] buffer = "This will be written in test.txt".getBytes();
            fos.write(buffer, 0 , buffer.length);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
