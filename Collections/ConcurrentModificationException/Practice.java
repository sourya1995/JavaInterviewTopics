package Collections.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("orange");
        fruits.add("grapes");

        
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
            if ("apple".equals(fruits.get(i))) {
                fruits.remove(i);
            }
        }
        

        for (String fruit : fruits) {
            System.out.println(fruit);
            if ("apple".equals(fruit)) {
                fruits.remove(fruit);
            }
        } // concurrent modification exception - iteration + modification at same time

        Iterator<String> fruitIterator = fruits.iterator();
        while (fruitIterator.hasNext()) {
            String fruit = fruitIterator.next();
            System.out.println(fruit);
            if ("apple".equals(fruit)) {
                fruitIterator.remove();
            }
        } //correct way
    }
}
