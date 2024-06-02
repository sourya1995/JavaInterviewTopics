package JavaCodingProblems.DataStructures.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
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
        Person other = (Person) obj;
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
    public int compareTo(Person o) {
        int lastNameCompare = this.lastName.compareTo(o.lastName);
        if (lastNameCompare == 0) {
            return this.firstName.compareTo(o.firstName);
        }
        return lastNameCompare;
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("John", "Doe"),
                new Person("Bob", "Dole"),
                new Person("Ronald", "McDonald"),
                new Person("Alice", "McDonald"),
                new Person("Jill", "Doe"));

        Collections.sort(people);
        System.out.println(people);
    }

}
