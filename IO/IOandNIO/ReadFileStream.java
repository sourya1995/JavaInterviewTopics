package IO.IOandNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileStream {
   public static void main(String[] args) {
    String filepath = "test.txt";
    FileInputStream fis = null;
    try{
        fis = new FileInputStream(filepath);
        int length = (int) new File(filepath).length();
        byte[] buffer = new byte[length];
        fis.read(buffer, 0, length);
    }catch (FileNotFoundException e){
        e.printStackTrace();
    } catch(IOException ie){
        ie.printStackTrace();
    } finally {
        if(fis != null){
            try {
                fis.close();
            } catch (IOException e) {
               
                e.printStackTrace();
            }
        }
    }
   }
}
