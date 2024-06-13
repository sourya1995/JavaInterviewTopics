import java.io.IOException;
import java.nio.file.StandardOpenOption;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.EnumSet;

public class MappedByteBufferExample {
    try(
    FileChannel fileChannel = (FileChannel.open(somefile, EnumSet.of(StandardOpenOption.READ))))
    {
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        if (buffer != null) {
            String bufferContent = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println(bufferContent);
            buffer.clear();
        }
    }

    // For huge files, it is advisable to traverse the buffer with a fixed size, as
    // follows:
    private static final int MAP_SIZE = 5242880;try(
    FileChannel fileChannel = (FileChannel.open(somefile, EnumSet.of(StandardOpenOption.READ))))
    {
        int position = 0;
        long length = fileChannel.size();
        while(position < length) {
            long remaining = length - position;
            int bytestomap = (int) Math.min(MAP_SIZE, remaining);
            try {
                MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytestomap);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            position += bytestomap;


    }
    
    //binary files
    try(FileChannel fileChannel = (FileChannel.open(binaryFile, EnumSet.of(StandardOpenOption.READ)))) {
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        System.out.println(buffer.limit() + "read");

    }

    private static final int MAP_SIZE = 5242880;try(
    FileChannel channel = FileChannel.open(binaryFile, EnumSet.of(StandardOpenOption.READ))){
        int position = 0;
        long length = channel.size();
        while(position < length){
            long remaining = length - position;
            int bytestomap = (int) Math.min(MAP_SIZE, remaining);
            try {
                MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytestomap);
               =
            } catch (Exception e) {
                e.printStackTrace();
            }

            position += bytestomap;
    }
       



    

    //writing binary files
    try(FileChannel fileChannel = Files.newByteChannel(path, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE))) {
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);

        if(buffer != null) {
            buffer.put(data);

    }
}
