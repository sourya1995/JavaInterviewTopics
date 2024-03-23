package ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// PersonComparator.java
public class PersonComparator implements Comparator<PersonComparator> {

    private final String lastName;
    private final String firstName;

    public PersonComparator(String lastName, String firstName) {
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
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        return hash;
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
        final PersonComparator other = (PersonComparator) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.firstName, other.firstName);
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("John", "Doe"),
                new Person("Bob", "Dole"),
                new Person("Ronald", "McDonald"),
                new Person("Alice", "McDonald"),
                new Person("Jill", "Doe"));

        Collections.sort(people, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getLastName().compareTo(o2.getLastName());
                if (result == 0) {
                    result = o1.getFirstName().compareTo(o2.getFirstName());
                }
                return result;
            }
        });

        Collections.sort(people, Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName));
    }

}
