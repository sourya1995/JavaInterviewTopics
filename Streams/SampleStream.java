package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SampleStream {
    public static void main(String[] args) {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        fruitStream.filter(s -> s.contains("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // sequential streams
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 42);
        long howManyOddNumbers = integerList.stream().filter(e -> (e % 2) == 1).count();
        System.out.println(howManyOddNumbers);

        // parallel streams
        long howManyOddNumbersParallel = integerList.parallelStream().filter(e -> (e % 2) == 1).count();
        System.out.println(howManyOddNumbersParallel);
    }
}
