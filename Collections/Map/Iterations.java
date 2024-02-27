package Collections.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Iterations {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");

        // Java 8
        map.forEach((k, v) -> System.out.println(k + " " + v));

        // Java 7
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // only keys
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // only values
        for (String value : map.values()) {
            System.out.println(value);
        }

        // Iterator
        Iterator entries = map.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<Integer, String> entry = (Entry<Integer, String>) entries.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        };
    }
}
