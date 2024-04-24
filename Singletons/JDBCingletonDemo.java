package Singletons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCingletonDemo {

    static int count = 1;
    static int choice;

    public static void main(String[] args) throws IOException {
        JDBCSingleton jdbc = JDBCSingleton.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("DATABASE-OPERATIONS");
            System.out.println(" --------------------- ");
            System.out.println(" 1. Insert ");
            System.out.println(" 2. View      ");
            System.out.println(" 3. Delete    ");
            System.out.println(" 4. Update    ");
            System.out.println(" 5. Exit      ");

            System.out.print("\n");
            System.out.print(
            "Enter the choice of what we want 
    to perform  in database     : ");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1: {
                    System.out.println("Enter username");
                    String username = br.readLine();
                    System.out.println("Enter password");
                    String password = br.readLine();
                    try {
                        int x = jdbc.insert(username, password);
                        if(x > 0){
                            System.out.println((count++) + "Data has inserted successfully");
                        } else {
                            System.out.println("Data has not been inserted successfully");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Enter key to continue");
                    System.in.read();
                }
                break;
                case 2: {
                    System.out.println("Enter username: ");
                    String username = br.readLine();
                    try {
                        jdbc.view(username);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Enter key to continue");
                    System.in.read();
                }
                break;
                case 3: {
                    System.out.println("Enter the userId to delete");
                    int userId = Integer.parseInt(br.readLine());
                    try {
                        int x = jdbc.delete(userId);
                        if(x > 0){
                            System.out.println((count++) + "Data has deleted successfully");
                        } else {
                            System.out.println("Data has not been deleted successfully");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Enter key to continue");
                    System.in.read();
                }
                break;

                case 4: {
                    System.out.println("Enter username to update");
                    String username = br.readLine();
                    System.out.println("Enter new password");
                    String password = br.readLine();
                    try {
                        int x = jdbc.update(username, password);
                        if(x > 0){
                            System.out.println((count++) + "Data has deleted successfully");
                        } else {
                            System.out.println("Data has not been deleted successfully");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Enter key to continue");
                    System.in.read();
                }
                break;

                default:
                    return;
            }
        } while(choice != 4);
    
    }
}
