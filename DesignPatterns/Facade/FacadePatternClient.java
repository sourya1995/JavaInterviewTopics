package DesignPatterns.Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadePatternClient {

    private static int choice;

    public static void main(String[] args) throws NumberFormatException, IOException {
        do {
            System.out.print("======= MobileShop ======= \n");
            System.out.print("     1. IPHONE       \n");
            System.out.print("     2. SAMSUNG       \n");
            System.out.print("     3. NOTHING     \n");
            System.out.print("     4. Exit               \n");
            System.out.print("Enter our choice: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(reader.readLine());
            Store store = new Store();

            switch (choice) {
                case 1:
                    store.iPhoneSale();
                    break;
                case 2:
                    store.samsungSale();
                    break;
                case 3:
                    store.nothingSale();
                    break;
                default:
                    System.out.println("empty cart!");
                    return;

            }
        } while (choice != 4);
    }
}
