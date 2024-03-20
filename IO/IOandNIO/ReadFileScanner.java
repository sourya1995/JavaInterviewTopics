package IO.IOandNIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileScanner {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("example.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine(); //line by lone
                String wordByWord = scanner.next(); //word by word
                System.out.println(line);
                System.out.println(wordByWord);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
