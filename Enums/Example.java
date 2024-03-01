package Enums;

import java.util.HashMap;
import java.util.Map;

enum Example {
    ONE(1), TWO(2);

    static Map<String, Integer> integers;

    private Example(int value) {
        putValue(this.name(), value);
    }

    private static void putValue(String key, int value) {
        if (integers == null) {
            integers = new HashMap<String, Integer>();
        }
        integers.put(key, value);
    } //this calls putValue method, and creates a new instance of hashMap

   
}
