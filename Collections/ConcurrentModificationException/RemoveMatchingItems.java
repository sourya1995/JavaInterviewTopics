package Collections.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;



public class RemoveMatchingItems {
    private static void removeNames(Collection<String> collection1, Collection<String> collection2) {
        Iterator<String> iterator = collection1.iterator();
        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next())) {
                iterator.remove();
            }
        }
    }
    public static void main(String[] args) {
        String[] names = { "Frank", "Petr", "Didier", "John", "Zlatan", "Javier", "Wesley", "Cristiano" };
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        String[] removeNames = { "Cristiano", "Zlatan" };
        List<String> removeNameList = new ArrayList<>(Arrays.asList(removeNames));

        

    }
}
