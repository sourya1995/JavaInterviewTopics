package ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {

    private final String lastName;
    private final String firstName;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person{"
                + "lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Person other) { //lexicographical order
      int lastNameCompare = lastName.compareTo(other.lastName);
      if (lastNameCompare == 0) {
          return firstName.compareTo(other.firstName);
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
    }

   

}
