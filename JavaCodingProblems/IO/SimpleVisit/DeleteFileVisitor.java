package JavaCodingProblems.IO.SimpleVisit;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


public class DeleteFileVisitor implements FileVisitor {

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
       return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        boolean deleted = delete((Path) file);
        if(deleted){
            System.out.println("Deleted:" + file);
        }else{
            System.out.println("Not Deleted:" + file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
       System.out.println("visited" + dir);

       boolean deleted = delete((Path) dir);
       if(deleted){
            System.out.println("Deleted:" + dir);
       }else{
            System.out.println("Not Deleted:" + dir);
       }

       return FileVisitResult.CONTINUE;
    }

    private static boolean delete(Path file) throws IOException {
        return Files.deleteIfExists(file);
    }

    public static void main(String[] args) {
        
    }
    
}
