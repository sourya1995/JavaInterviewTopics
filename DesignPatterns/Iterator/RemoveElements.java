package DesignPatterns.Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// This class demonstrates how to remove elements from a list using an iterator.

public class RemoveElements {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Samantha");
        names.add("Beth");
        names.add("Chris");
        names.add("Alice");
        System.out.println(names.size());
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if (name.startsWith("C")) {
                it.remove(); //can be called ONLY ONCE after next() - otherwise IllegalStateException
            }
        }
        System.out.println(names.size());
    }
}
/* for(String e: names){
    if(e.startsWith("C")){
        names.remove(e);
    } WILL CAUSE ConcurrentModificationException
} */