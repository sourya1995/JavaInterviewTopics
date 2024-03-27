package HTTP;

public class Person {
    private String firstName;
    private String lastName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Person returnFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person returnLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Sourya");
        person.setLastName("Bhattacharya");
        System.out.println(person.toString());

        System.out.println(new Person().returnLastName("Barnes").returnFirstName("John").toString());
    }

    
}
