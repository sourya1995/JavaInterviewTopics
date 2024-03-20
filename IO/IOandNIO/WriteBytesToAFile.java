package IO.IOandNIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytesToAFile {
    public static void main(String[] args) {
        byte[] bytes = {0x48, 0x65, 0x6c, 0x6c, 0x6f};
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream("hello.txt");
            stream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
        }

    }
}
