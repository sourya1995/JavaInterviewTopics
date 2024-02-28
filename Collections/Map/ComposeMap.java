package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class ComposeMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("key1", 1);
        map1.put("key2", 2);
        map1.put("key3", 3);

        Map<Integer, Double> map2 = new HashMap<Integer, Double>();
        map2.put(1, 1.0);
        map2.put(2, 2.0);
        map2.put(3, 3.0);

        Map<String, Double> map3 = new HashMap<>();
        map1.forEach((k, v) -> map3.put(k, map2.get(v)));
        System.out.println(map3);
    }
}
