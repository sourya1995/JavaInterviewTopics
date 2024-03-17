package IO.Paths;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WritingToFiles {
     public static void main(String[] args) throws IOException {
        Path p2 = Paths.get(URI.create("file:///home/testuser/File.txt"));
        byte[] content = Files.readAllBytes(p2); //read bytes into a byte array
        List<String> linesOfContent = Files.readAllLines(p2); //read lines into a list of strings

        List<String> lines = Arrays.asList(new String[]{"First Line", "Second Line", "Third Line"});
        Files.write(p2, lines);
        Files.write(p2, content);

    }
}
