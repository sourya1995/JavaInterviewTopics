package Streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IteratorToStream {
    public static void main(String[] args) {
        Iterator<String> iterator = Arrays.asList("A", "B", "C", "D").iterator();
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        Stream<String> stream = StreamSupport.stream(spliterator, false);
        stream.forEach(System.out::println);
    }
}
