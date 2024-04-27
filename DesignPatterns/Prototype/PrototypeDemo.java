package DesignPatterns.Prototype;

import java.io.BufferedReader;

public class PrototypeDemo {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.print("Enter the Employee Id: ");
        int eid = Integer.parseInt(in.readLine());
        System.out.print("\n");

        System.out.print("Enter the Employee Names: ");
        String ename = in.readLine();
        System.out.print("\n");

        System.out.print("Enter the Employee Designation: ");
        String edesignation = in.readLine();
        System.out.print("\n");

        System.out.print("Enter the Employee Address: ");
        String eaddress = in.readLine();
        System.out.print("\n");

        System.out.print("Enter the Employee Salary: ");
        double esalary = Double.parseDouble(br.readLine());
        System.out.print("\n");

        EmployeeRecord e1 = new EmployeeRecord(eid, ename,
                edesignation, esalary, eaddress);

        e1.showRecord();
        System.out.println("\n");
        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
        e2.showRecord();

    }
}
