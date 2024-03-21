package IO.IOandNIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintSubdirectories {
    public void iterate(final String dirPath) throws IOException{
        final DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(dirPath));
        for (final Path path : paths) {
            if (Files.isDirectory(path)) {
                System.out.println(path.getFileName());
               
            }
        }
    }
}
