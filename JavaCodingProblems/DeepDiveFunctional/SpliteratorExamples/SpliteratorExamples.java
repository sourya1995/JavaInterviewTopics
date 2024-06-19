package JavaCodingProblems.DeepDiveFunctional.SpliteratorExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExamples {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Spliterator<Integer> s1 = numbers.spliterator();
        s1.tryAdvance(e -> System.out.println("Advancing to the first element of s1 :" + e));
        System.out.println("estimated size of s1:" + s1.estimateSize());
        Spliterator<Integer> s2 = s1.trySplit();
        System.out.println("Estimated size s1: " + s1.estimateSize());
        System.out.println("Estimated size s2: " + s2.estimateSize());
        s1.forEachRemaining(e -> System.out.println("s1 :" + e));
        s2.forEachRemaining(e -> System.out.println("s2 :" + e));


    }

}
