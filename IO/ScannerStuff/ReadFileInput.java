package IO.ScannerStuff;

import java.io.File;
import java.util.Scanner;

public class ReadFileInput {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            };

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null)
                scanner.close();
        }
    }
}
