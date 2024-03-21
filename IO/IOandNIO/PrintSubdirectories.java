package IO.IOandNIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
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

    public void iterateAndFilter() throws IOException {
        Path dir = Paths.get("C:/for/foo");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:.*(?i:jpg|jpeg|png|gif|bmp|jpe|jfif)");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, entry -> matcher.matches(entry))) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        }
    }
}
