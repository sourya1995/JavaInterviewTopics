package Streams.IO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream("somefile.txt");
        DataInputStream instruction = new DataInputStream(input);
        int count = instruction.available(); //number of bytes that can be read from the input stream without blocking
        byte[] arr = new byte[count]; //array of bytes that can be read from the input stream without blocking
        instruction.read(arr); //read from the input stream
        for (byte b : arr) {
            char ch = (char) b;
            System.out.print(ch);
        }
    }
}
