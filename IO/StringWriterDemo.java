package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class StringWriterDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        char[] bufferArray = new char[1024];
        StringWriter writer = new StringWriter();
        FileInputStream inputStream = new FileInputStream("/path/to/file.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        int x;
        while ((x = buffer.read(bufferArray)) != -1) {
            writer.write(bufferArray, 0, x);
        }
        System.out.println(writer.toString());
        writer.close();
        buffer.close();
        
    }
}
