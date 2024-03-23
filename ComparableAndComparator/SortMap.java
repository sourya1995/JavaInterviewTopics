package ComparableAndComparator;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;



public class SortMap {

    public static void main(String[] args) {
        Map<String, Integer> numberOfEmployees = new HashMap<>();
        numberOfEmployees.put("executives", 10);
        numberOfEmployees.put("human ressources", 32);
        numberOfEmployees.put("accounting", 12);
        numberOfEmployees.put("IT", 100);

        numberOfEmployees.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(1).forEach(System.out::println);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(numberOfEmployees.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue());


    }
}
