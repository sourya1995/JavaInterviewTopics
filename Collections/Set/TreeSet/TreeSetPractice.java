package Collections.Set.TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(50);

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.headSet(30));
        System.out.println(treeSet.tailSet(30));
        System.out.println(treeSet.size());

        for (Integer i : treeSet) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Comparison
        // 1
        TreeSet<Person> treeSet2 = new TreeSet<>((personA, personB) -> Integer.compare(personA.getAge(), personB.getAge()));

        //2 using Comparator
        TreeSet<Person> treeSet3 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person personA, Person personB) {
                return Integer.compare(personA.getAge(), personB.getAge());
            }
        });

    }
}
