package JavaCodingProblems.IO.SimpleVisit;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

public class PathVisitor extends SimpleFileVisitor<Path> {
    
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if(exc != null){
            throw exc;
        }

        System.out.println("Visited directory");
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        PathVisitor visitor = new PathVisitor();
        try {
            Files.walkFileTree(path, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  

}
