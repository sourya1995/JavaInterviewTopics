package IO.IOandNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileStreamTWR {
    public static void main(String[] args) {
        String filepath = "test.txt";
        try(FileInputStream fis = new FileInputStream(filepath)){
            int length = (int) new File(filepath).length();
            byte[] buffer = new byte[length];
            fis.read(buffer, 0, length);
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
