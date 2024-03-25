package Networking;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadAFile {
    public static void main(String[] args) {
        String fileName =  "file.zip";
        String url = "http://example.com/";
        String path = "C:/Users/home";
        try(ReadableByteChannel rbc = Channels.newChannel(new URL(url + fileName).openStream())){
            try(FileChannel channel = new FileOutputStream(path + fileName).getChannel();){
                channel.transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.println("File downloaded successfully");
            }
        }
        catch(Exception e){
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
}
