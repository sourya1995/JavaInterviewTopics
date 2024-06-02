package JavaCodingProblems.DataStructures.Array;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;



public class Person2 implements Comparator<Person2> {

    private String firstName;
    private String lastName;

    public Person2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person2 other = (Person2) obj;
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    

   @Override
    public String toString() {
        return "Person2 [firstName=" + firstName + ", lastName=" + lastName + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
                + ", toString()=" + super.toString() + "]";
    }

public static void main(String[] args) {
    List<Person2> people = Arrays.asList(new Person2("John", "Doe"),
    new Person2("Bob", "Dole"),
    new Person2("Ronald", "McDonald"),
    new Person2("Alice", "McDonald"),
    new Person2("Jill", "Doe"));

    Collections.sort(people, new Comparator<Person2>(){
        @Override
        public int compare(Person2 o1, Person2 o2) {
            int result = o1.getLastName().compareTo(o2.getLastName());
            if(result == 0){
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return result;
        }

    });
    System.out.println(people);

   }

@Override
public int compare(Person2 o1, Person2 o2) {
    int result = o1.getLastName().compareTo(o2.getLastName());
    if (result == 0) {
        result = o1.getFirstName().compareTo(o2.getFirstName());
    }
    return result;
}

}
