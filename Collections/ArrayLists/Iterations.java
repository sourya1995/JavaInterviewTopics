package Collections.ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Iterations {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Clementine", "Duran", "Mike"));
        // Java 8
        names.forEach(System.out::println);
        names.parallelStream().forEach(System.out::println);

        // Java 7
        for (String name : names) {
            System.out.println(name); // enhanced for loop
        }

        // Java 5
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // Iterator
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        } // forward iteration
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        } // backward iteration
    }
}