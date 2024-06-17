package JavaCodingProblems.DeepDiveFunctional;

import java.util.List;
import java.util.stream.Collectors;

public class PeekTest {
    public static void main(String[] args) {
        List<String> list = List.of("Anna", "Caroline", "Jennifer", null, "Alisha", "Lindsay", "Ons");
        list.stream()
        .peek(p -> System.out.println("\tstream(): " + p))
        .filter(t -> t.startsWith("A"))
        .peek(p -> System.out.println("\tfilter(): " + p))
        .map(String::toUpperCase)
        .peek(p -> System.out.println("\tmap(): " + p))
        .sorted()
        .peek(p -> System.out.println("\tsorted(): " + p))
        .collect(Collectors.toList());

        
    }
}
