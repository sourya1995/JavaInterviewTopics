package Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class toStream {
    public static void main(String[] args) {
        String[] arr = new String[] { "str1", "str2", "str3" };
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

        int[] intArr = new int[] { 1, 2, 3 };
        IntStream intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::println);

        /* Arrays.stream() is type specific, Stream.of() is not */

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        stringStream.forEach(System.out::println);

        Stream<Double> doubleStream = Stream.of(new Double[] { 1.0, 2.0, 3.0 });
        doubleStream.forEach(System.out::println);
    }
}
