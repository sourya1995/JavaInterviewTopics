package Arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class Iterators {
    public static void main(String[] args) {
        Integer[] boxed = { 1, 2, 3 };
        Iterable<Integer> boxedIt = Arrays.asList(boxed);
        Iterator<Integer> it = boxedIt.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        };

        // streams
        int[] primitives = { 1, 2, 3 };
        IntStream stream = Arrays.stream(primitives);
        stream.forEach(System.out::println);

        PrimitiveIterator.OfInt it2 = stream.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        };

    }
}
