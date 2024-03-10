package Collections.ConcurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Object> concurrentHashMap = new ConcurrentHashMap<Integer, Object>();
        Object value = new Object();
        Integer key = 1;
        Object previousValue = concurrentHashMap.putIfAbsent(1, value);
        if (previousValue != null) {
            // do something
        } else {
            // something else
        }
    }
}
