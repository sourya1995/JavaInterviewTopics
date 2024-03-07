package Streams;

import java.util.stream.IntStream;

public class IterateOverIndexes {
    public static void main(String[] args) {
        String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
        IntStream.range(0, names.length).mapToObj(i -> String.format("#%d, %s", i + 1, names[i]))
        .forEach(System.out::println);

    }
}
