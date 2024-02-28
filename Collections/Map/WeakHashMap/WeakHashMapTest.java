package Collections.Map.WeakHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        Map HashMap = new HashMap();
        Map WeakHashMap = new WeakHashMap();

        String keyHashMap = new String("keyHashMap");
        String keyWeakHashMap = new String("keyWeakHashMap");

        HashMap.put(keyHashMap, "21Savage");
        WeakHashMap.put(keyWeakHashMap, "Stormzy");

        System.gc();

        System.out.println("Before: hash map value:" + HashMap.get("keyHashMap") + " and weak hash map value:"
                + WeakHashMap.get("keyWeakHashMap"));

        keyHashMap = null;
        keyWeakHashMap = null; //we inform the JVM that we don't need this reference anymore

        System.gc();

        System.out.println("After: hash map value:"+HashMap.get("keyHashMap")+" and weak hash map value:"+WeakHashMap.get("keyWeakHashMap"));

    }
}
