package JavaCodingProblems.IO.SimpleVisit;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;

public class CopyFileVisitor implements FileVisitor {
    private final Path copyFrom;
    private final Path copyTo;

    public CopyFileVisitor(Path copyFrom, Path copyTo) {
        this.copyFrom = Objects.requireNonNull(copyFrom, "The location to copy from cannot be null");
        this.copyTo = Objects.requireNonNull(copyFrom, "The location to copy to cannot be null");
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize((Path) dir));
        try {
            Files.copy((Path) dir, newDir, REPLACE_EXISTING, COPY_ATTRIBUTES);
        } catch (Exception e) {
            System.out.println("Unable to create" + newDir);
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Copy file: " + (Path) file);

        try {
            copySubTree((Path) file, copyTo.resolve(copyFrom.relativize((Path) file)));
        } catch (IOException e) {
            System.err.println("Unable to copy " + copyFrom + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {

        if (exc instanceof FileSystemLoopException) {
            System.err.println("Cycle was detected: " + (Path) file);
        } else {
            System.err.println("Error occured, unable to copy:" + (Path) file + " [" + ioe + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize((Path) dir));

        try {
            FileTime time = Files.getLastModifiedTime((Path) dir);
            Files.setLastModifiedTime(newDir, time);

        } catch (IOException e) {
            System.out.println("Unable to preserve the time attribute");
        }

        return FileVisitResult.CONTINUE;

    }

    private static void copySubTree(Path from, Path to) throws IOException {
        Files.copy(from, to, REPLACE_EXISTING, COPY_ATTRIBUTES);
    }

}
