package JavaCodingProblems.DeepDiveFunctional.InfiniteStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class InfStreamOps {
    public static void main(String[] args) {
        Stream<Integer> infStream = Stream.iterate(1, n -> n <= 10, n -> n + 1);
        // infStream.limit(10).forEach(System.out::println);

        List<Integer> result = infStream
        .filter(i -> i % 2 == 0)
        .limit(10)
        .collect(Collectors.toList());
        System.out.println(result);
       
    }
}
