package IO.IOandNIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Lenovo\\Desktop\\test.txt");
        List<String> lines = Arrays.asList("The first line", "The second line", "The third line");
        if(file.exists()){
            throw new IOException("File already exists");

        }
        try(FileOutputStream outputStream = new FileOutputStream(file)){
            for(String line : lines){
                outputStream.write(line.getBytes());
                outputStream.write("\n".getBytes());
            }
        }
    }
}
