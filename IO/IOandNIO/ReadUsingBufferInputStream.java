package IO.IOandNIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadUsingBufferInputStream {
    public static void main(String[] args) {
        String source = "hello.txt";
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source))){
            byte data;
            while((data = (byte) bis.read()) != -1){
                System.out.println((char)data);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
