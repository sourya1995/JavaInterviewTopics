package IO.IOandNIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class IterateFiles {
    public static void main(String[] args) throws IOException {
        File folder = new File("some/directory/path.txt");
        Path path = folder.toPath();

        //IO
        for(File selectedFile : folder.listFiles()){
            System.out.println((selectedFile.isDirectory() ? "d" : "f") + " " + selectedFile.getAbsolutePath());
        }

        //NIO
        Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), 1, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path selectedPath, BasicFileAttributes attrs) throws IOException {
                System.out.println("d " + selectedPath.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path selectedPath, BasicFileAttributes attrs) throws IOException {
                System.out.println("d " + selectedPath.toAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
