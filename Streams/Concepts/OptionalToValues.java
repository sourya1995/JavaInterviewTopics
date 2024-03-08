package Streams.Concepts;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalToValues {
    public static void main(String[] args) {
        Optional<String> op1 = Optional.empty();
        Optional<String> op2 = Optional.of("Hello, World");

        List<String> result = Stream.of(op1, op2)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
