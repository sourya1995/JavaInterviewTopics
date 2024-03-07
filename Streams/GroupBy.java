package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Sam", "Rossi"),
                new Person("Sam", "Verdi"),
                new Person("John", "Bianchi"),
                new Person("John", "Rossi"),
                new Person("John", "Verdi"));
        Map<String, List<String>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getFirstName, Collectors.mapping(Person::getLastName, Collectors.toList())));
        System.out.println(map);
    }
}
