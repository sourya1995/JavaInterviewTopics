package IO.IOandNIO;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CreateZIPFile {
    public static void main(String[] args) {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        env.put("encoding", "UTF-8");
        URI uri = URI.create("path/to/file.zip");
        try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path newFile = zipfs.getPath("newFile.txt");
            Files.write(newFile, "Hello World".getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
