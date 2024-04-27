package DesignPatterns.Prototype;

public class EmployeeRecord implements Prototype {

    private int id;
    private String names, designation;
    private double Salary;
    private String address;

    public EmployeeRecord() {
        System.out.println(
        " Employee Records of 
       Oracle Corporation "); 
        System.out.println("-----------------------");
        System.out.
                println("Eid" + "\t" + "Enames" + "\t" + "Edesignation" +"\
       t"+"Esalary"+"\t\t"+"Eaddress"

    
    ); 
        
        }

    

    public EmployeeRecord(int id, String names, String designation, double salary, String address) {
        this();
        this.id = id;
        this.names = names;
        this.designation = designation;
        Salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(id + "\t" + names + "\t" + designation + "\t" + Salary + "\t" + address);
    }


    @Override
    public Prototype getClone() {
        return new EmployeeRecord(id, names, designation, Salary, address);
    }

}
