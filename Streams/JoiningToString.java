package Streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningToString {
    public static void main(String[] args) {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        String result = fruitStream.filter(s -> s.contains("e")).map(String::toUpperCase).sorted()
                .collect(Collectors.joining(",", "Prefix: ", " Suffix"));
        System.out.println(result);
    }
}
