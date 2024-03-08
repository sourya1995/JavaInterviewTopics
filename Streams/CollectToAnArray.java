package Streams;

import java.util.Arrays;
import java.util.List;

public class CollectToAnArray {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "pear", "kiwi", "orange");
        String[] filteredFruits = fruits.stream().filter(s -> s.contains("a")).toArray(String[]::new);
        System.out.println(Arrays.toString(filteredFruits));
    }
}
