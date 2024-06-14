package JavaCodingProblems.IO;

import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.Instant;




public class FilterFiles {
    private static final Path PATH = Paths
            .get("C:\\Users\\johnw\\OneDrive\\Desktop\\JavaInterviewTopics\\JavaCodingProblems\\IO\\");

    public void filterFiles() throws IOException {
        DirectoryStream.Filter<Path> sizeFilter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.size(entry) > 1024 * 1024 * 10;
            }
        };

        DirectoryStream.Filter<Path> folderFilter = new DirectoryStream.Filter<Path>() {

            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry, LinkOption.NOFOLLOW_LINKS);
            }

        };

        DirectoryStream.Filter<Path> todayFilter = new DirectoryStream.Filter<Path>() {

            @Override
            public boolean accept(Path entry) throws IOException {
                FileTime lastModified = Files.readAttributes(entry, BasicFileAttributes.class).lastModifiedTime();
                LocalDate lastModifiedDate = lastModified.toInstant().atOffset(ZoneOffset.UTC).toLocalDate();
                LocalDate todayDate = Instant.now().atOffset(ZoneOffset.UTC).toLocalDate();
                return lastModifiedDate.equals(todayDate);
            }

        };

        String[] files = PATH.toFile().list(filter);

        FilenameFilter filter = (f, n) -> n.endsWith(".pdf");

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(PATH, sizeFilter)) {
            for (Path file : ds) {
                try {
                    System.out.println(file.getFileName() + " "
                            + Files.readAttributes(file, BasicFileAttributes.class).size() + " bytes");
                } catch (IOException ex) {
                    // Handle exception
                    ex.printStackTrace();
                }
            }
        }
    }

}
