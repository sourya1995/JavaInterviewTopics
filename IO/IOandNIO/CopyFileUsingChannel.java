package IO.IOandNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

public class CopyFileUsingChannel {

    public static void main(String[] args) {
        File sourceFile = new File("hello.txt");
        File sinkFile = new File("hello2.txt");
        copy(sourceFile, sinkFile);
    }
    public static void copy(File sourceFile, File destFile){
        if(!sourceFile.exists() || !destFile.exists()) {
            System.out.println("Source or destination file does not exist");
            return;
        }

        try(FileChannel source = new FileInputStream(sourceFile).getChannel();
        FileChannel sink = new FileOutputStream(destFile).getChannel()){
            source.transferTo(0, source.size(), sink);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
