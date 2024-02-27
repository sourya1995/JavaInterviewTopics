package Collections.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Iterations {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>(Arrays.asList("Clementine", "Duran", "Mike"));
        names.forEach(System.out::println);

        // Java 7
        for (String name : names) {
            System.out.println(name);
        }

        // Java 5
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.toArray()[i]);
        }

        // Iterator
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
