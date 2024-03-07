package Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concatenation {
    public static void main(String[] args) {
        Collection<String> abc = Arrays.asList("a", "b", "c");
        Collection<String> digits = Arrays.asList("1", "2", "3");
        Collection<String> greekAbc = Arrays.asList("alpha", "beta", "gamma");

        // type 1
        final Stream<String> concat3 = Stream.concat(Stream.concat(abc.stream(), digits.stream()), greekAbc.stream());
        System.out.println(concat3.collect(Collectors.joining(",")));

        // type 2
        final Stream<String> concat2 = Stream.of(abc.stream(), digits.stream(), greekAbc.stream()).flatMap(s -> s);
        System.out.println(concat2.collect(Collectors.joining(",")));

        // type 3
        final Stream<String> concat1 = Stream.of(abc, digits, greekAbc).flatMap(Collection::stream);
        System.out.println(concat1.collect(Collectors.joining(",")));
        
        // type 4
        final Stream<String> concat = Stream.of(abc, digits, greekAbc).flatMap(s -> s.stream());
        System.out.println(concat.collect(Collectors.joining(",")));
    }
}
