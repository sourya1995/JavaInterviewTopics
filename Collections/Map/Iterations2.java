package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class Iterations2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Jon Skeet", 927_654);
        map.put("BalusC", 708_826);
        map.put("Darin Dimitrov", 715_567);

        for (String key : map.keySet()) {
            System.out.println(key);
        } // method 1 - returns a Set

        for (Integer value : map.values()) {
            System.out.println(value);
        } // method 2 - returns a Collection

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        } // method 3 - returns a collection of Map.Entry<String, Integer> objects
    }
}
