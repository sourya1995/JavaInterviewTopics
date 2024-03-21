package IO.IOandNIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFile {
    public static void main(String[] args) throws IOException {
        FileInputStream ios = new FileInputStream("somefile.txt");
        FileChannel channel = ios.getChannel();
        FileLock lock = channel.tryLock(0, Long.MAX_VALUE, true);
        if(lock == null){
            System.out.println("unable to acquire lock");
        } else {
            System.out.println("lock acquired successfully");
        }

        if(lock != null) lock.release();
        ios.close();
        channel.close();

        

    }
}
