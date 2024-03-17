package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteLineToFile {
    public void writeLineToFile(String str) throws IOException {
        File file = new File("file.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(str);
        } finally{
            if(bw != null){
                bw.close();
            }
        }

    }

    public void writeLineToFileJava7(String str) throws IOException{
        Path path = Paths.get("file.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            bw.write(str);
        }
    }
}
