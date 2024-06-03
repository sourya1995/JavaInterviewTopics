package JavaCodingProblems.DataStructures.Array.Immutability;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;


public class Test {

    private static final List<Integer> LIST = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
    private static final List<Integer> LIST = List.of(1, 2, 3, 4, 5);

    public static void main(String[] args) {
       

    }
}
