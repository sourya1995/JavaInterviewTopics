package IO.ScannerStuff;

import java.util.Scanner;
public class CustomDelimiter {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner("i,like,unicorns").useDelimiter(",");
            while(scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
}
