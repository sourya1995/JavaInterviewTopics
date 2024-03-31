package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadUTF8File {

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("test.txt"), StandardCharsets.UTF_8)) {
            writer.write("some text");
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("test.txt"), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } //For big files

        String s = new String(Files.readAllBytes(Paths.get("test.txt")), StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
