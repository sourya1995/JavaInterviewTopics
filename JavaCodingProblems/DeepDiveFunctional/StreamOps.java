package JavaCodingProblems.DeepDiveFunctional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamOps {

    private static boolean evenBetween0and10(int i) {
        return i % 2 == 0 && i <= 10 && i > 0;
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
        List<Integer> result = ints
        .stream()
        .peek(s -> System.out.println("\tstream():" + s))
        .filter(i -> i != 0)
        .peek(s -> System.out.println("\tfilter():" + s))
        .collect(Collectors.toList());
        System.out.println(result);

        List<Integer> result2 = ints
        .stream()
        .peek(s -> System.out.println("\tstream():" + s))
        .filter(i -> i != 0)
        .peek(s -> System.out.println("\tfilter():" + s))
        .distinct()
        .peek(s -> System.out.println("\tdistinct():" + s))
        .skip(1)
        .peek(s -> System.out.println("\tskip():" + s))
        .limit(3)
        .peek(s -> System.out.println("\tlimit():" + s))
        .collect(Collectors.toList());
        System.out.println(result2);

        List<Integer> result3 = ints
        .stream()
        .peek(s -> System.out.println("\tstream():" + s))
        .filter(StreamOps::evenBetween0and10)
        .peek(s -> System.out.println("\tfilter():" + s))
        .collect(Collectors.toList());
        System.out.println(result3);



    }
}
