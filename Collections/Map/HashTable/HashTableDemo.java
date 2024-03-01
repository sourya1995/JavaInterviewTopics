package Collections.Map.HashTable;

import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(100, "Amit");
        ht.put(102, "Ravi");
        ht.put(101, "Vijay");
        ht.put(103, "Rahul");
        System.out.println("-------------Hashtable--------------");
        for (Integer key : ht.keySet()) {
            System.out.println(key + " " + ht.get(key));
        }

        for (Map.Entry<Integer, String> m : ht.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        };
    }
}
