package JavaCodingProblems.IO.SimpleVisit;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Objects;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;



public class SearchFileVisitor implements FileVisitor {

    private final Path fileNameToSearch;
    private boolean fileFound;

    

    public SearchFileVisitor(Path fileNameToSearch) {
        this.fileNameToSearch = Objects.requireNonNull(fileNameToSearch, "The file to search cannot be null");
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
       fileFound = search(file);

       if(!fileFound){
            return FileVisitResult.CONTINUE;
       } else {
            return FileVisitResult.TERMINATE;
       }
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
       return FileVisitResult.CONTINUE;
    
    }

    public boolean isFileFound() {
        return fileFound;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        if(exc != null){
            throw exc;
        }

        System.out.println("Visited" + dir);
        return FileVisitResult.CONTINUE;
    }

    private boolean search(Path file) throws IOException {
        Path fileName = file.getFileName();
        if(fileNameToSearch.equals(fileName)){
            System.out.println("Searched file was found at: " + fileNameToSearch + "in" + file.toRealPath().toString());
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Path searchFile = Paths.get("someFile.txt");
        SearchFileVisitor visitor = new SearchFileVisitor(searchFile);
        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for(Path root: roots){
            if(!visitor.isFileFound()){
                Files.walkFileTree(root, opts, Integer.MAX_VALUE, visitor);
            }
        }

        if(!visitor.isFileFound()){
            System.out.println("The file" + searchFile + "was not found");
        }

        

    }

    
}
