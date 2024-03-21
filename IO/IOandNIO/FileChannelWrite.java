package IO.IOandNIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {

    public static void main(String[] args) {
        File outputFile = new File("hello.txt");
        String text = "something";
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            FileChannel fileChannel = fos.getChannel();
            byte[] bytes = text.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            fileChannel.write(byteBuffer);
            fileChannel.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
