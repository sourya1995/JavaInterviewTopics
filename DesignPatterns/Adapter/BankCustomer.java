package DesignPatterns.Adapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {

    @Override
    public void giveBankDetails() {
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter account holder name:");
           String customerName = reader.readLine();
           System.out.println("Enter account number:");
           String accountNumber = reader.readLine();
           System.out.println("Enter bank name:");
           String bankName = reader.readLine();
           setAccountHolderName(customerName);
           setAccountNumber(accountNumber);
           setBankName(bankName);

       } catch (Exception e) {
        e.printStackTrace();
       }
    }

    @Override
    public String getCreditCard() {
       long accno = getAccountNumber();
       String accountHolderName = getAccountHolderName();
       String bankName = getBankName();

       return ("Account holder name: " + accountHolderName + "\nAccount number: " + accno + "\nBank name: " + bankName + "\n");
    }
    
}

//Adapter