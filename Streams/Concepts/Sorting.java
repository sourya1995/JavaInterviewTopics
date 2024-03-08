package Streams.Concepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("Sydney");
        data.add("London");
        data.add("New York");
        data.add("Amsterdam");
        data.add("Mumbai");
        data.add("California");
        List<String> sortedData = data.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        List<String> reverseData = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedData);

    }
}
