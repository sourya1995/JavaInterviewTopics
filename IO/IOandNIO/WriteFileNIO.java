package IO.IOandNIO;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class WriteFileNIO {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\test.txt");
        Path path = file.toPath();
        List<String> lines = Arrays.asList("The first line", "The second line", "The third line");
        if(file.exists()){
            throw new IOException("File already exists");

        }

        try(OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE_NEW)){
            for(String line: lines){
                outputStream.write((line + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
