package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapPractice {
    public static void main(String[] args) {
        // 3 separate lists - to one list
        List<String> list1 = Arrays.asList("one", "two");
        List<String> list2 = Arrays.asList("three", "four", "five");
        List<String> list3 = Arrays.asList("six");
        List<String> finalList = Stream.of(list1, list2, list3).flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(finalList);

        // map with a list of values -> single list
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        map.put("a", Arrays.asList(1, 2, 3));
        map.put("b", Arrays.asList(4, 5, 6));
        List<Integer> allValues = map.values().stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(allValues);

        // List of Map to a continuous list
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "one");
        map1.put("2", "two");
        Map<String, String> map2 = new HashMap<>();
        map2.put("3", "three");
        map2.put("4", "four");
        list.add(map1);
        list.add(map2);

        Set<String> output = list.stream().map(Map::values).flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println(output);
    }
}
